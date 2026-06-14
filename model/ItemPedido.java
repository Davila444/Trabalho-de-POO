package model;
public class ItemPedido {
    private int quantidade;
    private String produto;
    private int precoUnitario;
    
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public int getPrecoUnitario() {
        return precoUnitario;
    }
    public void setPrecoUnitario(int precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    
}
