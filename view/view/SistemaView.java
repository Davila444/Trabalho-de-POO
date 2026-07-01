// feito por IA...

package view;


import controller.*;
import model.*;
import excessoes.*;

import java.util.Scanner;

public class SistemaView {

    private LojaOnline loja;
    private Scanner scanner;
    private Administrador admin;

    // Construtor: Prepara o sistema quando ele é iniciado
    public SistemaView() {
        this.scanner = new Scanner(System.in);
        this.loja = new LojaOnline();
        this.loja.setNome("Super Loja Tech");
        // Criando um Administrador padrão para você testar
        this.admin = new Administrador("A1", "Admin Mestre", "admin@loja.com", "admin123");
    }

    // Aquele loop gigante principal agora é este método!
    public void iniciarSistema() {
        int opcaoPrincipal = 0;

        System.out.println("=================================================");
        System.out.println("   BEM-VINDO AO SISTEMA: " + loja.getNome());
        System.out.println("=================================================");

        while (opcaoPrincipal != 3) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Login Cliente");
            System.out.println("2. Cadastro Cliente");
            System.out.println("3. Sair do Sistema");
            System.out.println("4. Acesso Administrador (Simulação)");
            System.out.print("Escolha uma opção: ");

            opcaoPrincipal = Integer.parseInt(scanner.nextLine());

            switch (opcaoPrincipal) {
                case 1:
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Senha: ");
                    String senha = scanner.nextLine();

                    Cliente clienteLogado = null;
                    for (Cliente c : loja.getClientes()) { 
                        try {
                            if (c.Autenticar(email, senha)) {
                                clienteLogado = c;
                                break;
                            }
                        } catch (LoginInvalidoException e) {}
                    }

                    if (clienteLogado != null) {
                        clienteLogado.login();
                        menuCliente(clienteLogado);
                    } else {
                        System.out.println("❌ Credenciais inválidas ou usuário não encontrado.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- NOVO CADASTRO ---");
                    loja.cadastrarCliente(scanner);
                    break;

                case 3:
                    System.out.println("Desligando o sistema... Até logo!");
                    break;

                case 4:
                    admin.login();
                    menuAdministrador();
                    break;

                default:
                    System.out.println("⚠️ Opção inválida.");
                    break;
            }
        }
        scanner.close();
    }

    // ==============================================================
    //                       MENU DO CLIENTE
    // ==============================================================
    private void menuCliente(Cliente cliente) {
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("\n--- MENU DO CLIENTE: " + cliente.getNome() + " ---");
            System.out.println("1. Ver catálogo de produtos");
            System.out.println("2. Adicionar produto ao carrinho");
            System.out.println("3. Ver meu carrinho / Calcular total");
            System.out.println("4. Finalizar compra");
            System.out.println("5. Exibir meu histórico de compras");
            System.out.println("6. Deslogar");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    loja.listarProdutos();
                    break;
                case 2:
                    System.out.print("Nome exato do produto: ");
                    String nomeBusca = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int qtd = Integer.parseInt(scanner.nextLine());

                    try {
                        Produto p = loja.buscarProduto(nomeBusca);
                        cliente.getCarrinho().adicionarItem(new ItemCarrinho(p, qtd));
                        System.out.println("✅ Produto adicionado ao carrinho!");
                    } catch (ProdutoNaoEncotradoException e) {
                        System.out.println("❌ " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("--- SEU CARRINHO ---");
                    if (cliente.getCarrinho().getItens().isEmpty()) {
                        System.out.println("O carrinho está vazio.");
                    } else {
                        for (ItemCarrinho item : cliente.getCarrinho().getItens()) {
                            System.out.println("- " + item.getQuantidade() + "x " + item.getProduto().getNome());
                        }
                        System.out.println("TOTAL: R$ " + cliente.getCarrinho().calcularTotal());
                    }
                    break;
                case 4:
                    if (cliente.getCarrinho().getItens().isEmpty()) {
                        System.out.println("❌ Não é possível finalizar um pedido com o carrinho vazio.");
                    } else {
                        loja.criarPedido(cliente);
                        cliente.adicionarPedido(loja.getPedidos().get(loja.getPedidos().size() - 1));
                        cliente.getCarrinho().getItens().clear(); 
                        System.out.println("✅ Pedido finalizado com sucesso!");
                    }
                    break;
                case 5:
                    cliente.exibirHistorico();
                    break;
                case 6:
                    System.out.println("Deslogando do perfil...");
                    break;
                default:
                    System.out.println("⚠️ Opção inválida.");
            }
        }
    }

    // ==============================================================
    //                     MENU DO ADMINISTRADOR
    // ==============================================================
    private void menuAdministrador() {
        int opcao = 0;
        while (opcao != 4) {
            System.out.println("\n--- PAINEL DO ADMINISTRADOR ---");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Remover Produto");
            System.out.println("4. Deslogar");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço (ex: 150.50): ");
                    double preco = Double.parseDouble(scanner.nextLine().replace(",", "."));
                    System.out.print("Estoque inicial: ");
                    int estoque = Integer.parseInt(scanner.nextLine());

                    Produto novoProduto = new ProdutoFisico(String.valueOf(System.currentTimeMillis()), nome, preco, estoque);
                    loja.getProdutos().add(novoProduto);
                    admin.cadastrarProduto(novoProduto);
                    break;
                case 2:
                    System.out.println("--- ESTOQUE ATUAL ---");
                    if (loja.getProdutos().isEmpty()) {
                        System.out.println("Nenhum produto cadastrado no catálogo.");
                    } else {
                        loja.listarProdutos();
                    }
                    break;
                case 3:
                    System.out.print("Nome do produto a remover: ");
                    String nomeRemover = scanner.nextLine();
                    try {
                        Produto p = loja.buscarProduto(nomeRemover);
                        loja.getProdutos().remove(p);
                        System.out.println("✅ Produto removido do catálogo com sucesso!");
                    } catch (ProdutoNaoEncotradoException e) {
                        System.out.println("❌ " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Saindo do painel administrativo...");
                    break;
                default:
                    System.out.println("⚠️ Opção inválida.");
            }
        }
    }
}

// Classe concreta auxiliar apenas para o administrador conseguir cadastrar os produtos
class ProdutoFisico extends Produto {
    public ProdutoFisico(String id, String nome, double preco, int estoque) {
        super(id, nome, preco, estoque);
    }
}


