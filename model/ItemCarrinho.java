package model;
/**
 * A classe que representa os itens escolhidos pelo cliente para carrinho.
 */
public class ItemCarrinho {
    private Produto produto;
    private int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
    public Produto getProduto(){
        return produto;
    }
    public void setProduto(Produto produto){
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
}
