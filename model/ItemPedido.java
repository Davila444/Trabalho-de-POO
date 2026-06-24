package model;
/**
 * A classe que representa os itens que foram confirmados do carrindo para o pedido e finalização da compra.
 */
public class ItemPedido {
    private String produto;
    private int quantidade;
    private double precoUnitario;

    public ItemPedido(String produto, int quantidade, double precoUnitario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        }   

    public String getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    
}
