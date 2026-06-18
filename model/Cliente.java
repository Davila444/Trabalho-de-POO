package model;

import java.util.ArrayList;
import java.util.List;

import controler.Carrinho;


public class Cliente extends Usuario{

    private Carrinho carrinho;
    private List<Pedido> historicoPedidos;
    private String endereco;

    public Cliente(String id, String email, String senha, String nome) {
        super(id, email, senha, nome);
        this.carrinho = new Carrinho();
        this.historicoPedidos = new ArrayList<Pedido>();
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
        System.out.println("Atualiazando o endereço do Cliente para: ' + this.endereco");
    }
    
    public void cadastrar() {
        System.out.println("Cliente " + super.getNome() + " cadastrado.");
    }

}
