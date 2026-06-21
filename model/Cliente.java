package model;

import java.util.ArrayList;
import java.util.List;

import controller.Carrinho;
import interfaces.ICliente;


public class Cliente extends Usuario implements ICliente{

    private Carrinho carrinho;
    private List<Pedido> historicoPedidos;
    private String endereco;

    public Cliente(String id, String nome, String email, String senha) {
        super(id, nome, email, senha);
        this.carrinho = new Carrinho();
        this.historicoPedidos = new ArrayList<Pedido>();
    }

    @Override
    public void adicionarPedido(Pedido pedido) {
        this.historicoPedidos.add(pedido);
        System.out.println("Pedido adicionado no historico!");
    }

    @Override
    public void exibirHistorico() {
        System.out.println("Historico de compras de " + super.getNome());
        if (historicoPedidos.isEmpty()) {
            System.out.println("Nao ha pedido no carrinho");
        }
        else {
            for (Pedido p : historicoPedidos) {
                System.out.println("Pedido ID: " + p.getIdPedido() + "Status:" + p.getStatus());
            }
        }
    }
    public Carrinho getCarrinho() {
        return carrinho;
    }

    public List<Pedido> getHistoricoPedido() { 
        return historicoPedidos;
    }    

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    } 

    @Override
    public void atualizarDados() {
        System.out.println("Atualiazando o endereço do Cliente para: " + this.endereco);
    }
    @Override
    public void cadastrar() {
        System.out.println("Cliente " + super.getNome() + " cadastrado.");
    }
    @Override
    public void login() {
        System.out.println("Cliente " + super.getNome() + "acessou o sistema de compras");

    }
}
