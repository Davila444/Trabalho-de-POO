package controller;
import model.Cliente;
import model.Pedido;
import model.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LojaOnline {
    private String nome;
    private List<Cliente> clientes = new ArrayList<>();
    private List<Pedido> pedidos  = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void cadastrarCliente(Scanner scanner){
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Endereco: ");
        String endereco = scanner.nextLine();

        Cliente cliente = new Cliente(nome, email, endereco, senha);
        clientes.add(cliente);
        System.out.println("cliente cadrastrado com sucesso");

    }

    public void listarProdutos(){
        //Tenho que lembrar de terminar a lista em adninistrador(por isso o erro).
        for (Produto p : produtos) {
            System.out.println(p.getNome() + ": R$" + p.getPreco());
        }

    }

    public void criarPedido(Cliente cliente){
        Carrinho carrinho = cliente.getCarrinho();

        if (carrinho.getItens().isEmpty()) {
            System.out.println("Não tem nada no carrinho");
            return;
        }

        Pedido pedido = new Pedido(cliente, carrinho.getItens());
        pedidos.add(pedido);
        System.out.println("Pedido criado");
    }

}
