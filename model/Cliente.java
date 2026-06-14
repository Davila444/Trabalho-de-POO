
import java.util.Arraylist;
import java.util.List;
package model;
import controler.Carrinho;
import Pedido;
import Usuario;


class Cliente extends Usuario{
    private Carrinho carrinho;
    private List<Pedido> historicoPedidos;

    public Cliente(String id, String email, String senha, String nome) {
        super(id, email, senha, nome);
        this.carrinho = new Carrinho();
        this.historicoPedidos = new Arraylist<>();
    }
    public Carrinho getCarrinho() {
        return carrinho;
    }
    public List<Pedido> getHistoricoPedido() { 
        return historicoPedidos;
    }    
    private String endereco;
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    } 


    public void atualizarDados(){

    }
    
    public void cadastrar(){

    }

}
