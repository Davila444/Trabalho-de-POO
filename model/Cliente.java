package model;

import java.util.ArrayList;
import java.util.List;

import interfaces.ICliente;

public class Cliente extends Usuario implements ICliente {

    private Carrinho carrinho;
    private List<Pedido> historicoPedidos;
    private String endereco;

    public Cliente(String id,String nome, String email, String senha) {
        super(id, email, nome, senha);
        this.carrinho = new Carrinho();
        this.historicoPedidos = new ArrayList<Pedido>();
    }

    @Override
    public void adicionarPedido(Pedido pedido) {
        this.historicoPedidos.add(pedido);
        System.out.println("Pedido adicionado ao historico com sucesso");
    }
    
    @Override
    public void exibirHistorico() {
        System.out.println("Historico de compras de " + super.getNome() + "." );

        if (historicoPedidos.isEmpty()) {
            System.out.println("Nenhum pedido realizado ainda.");
        } else {
            for (Pedido p : historicoPedidos) {
                System.out.println("Pedido ID: " + p.getIdPedido() + " Status: " + p.getStatus());
            }
        }
    }
    @Override
    public void atualizarDados() {
        System.out.println("Atualiazando o endereço do Cliente para: " + this.endereco);
    }
    
    public void cadastrar() {
        System.out.println("Cliente " + super.getNome() + " cadastrado.");
    }

public Carrinho getCarrinho() {
        return carrinho;
    }

    public List<Pedido> getHistoricoPedidos() {
        return historicoPedidos;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
