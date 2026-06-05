abstract class Produto {
    private int id;
    private String nome;
    private int preco;
    private int estoque;

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public int getPreco() {
        return preco;
    }



    public void setPreco(int preco) {
        this.preco = preco;
    }



    public int getEstoque() {
        return estoque;
    }



    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }



    public void atualizarEstoque(){

    }

}
