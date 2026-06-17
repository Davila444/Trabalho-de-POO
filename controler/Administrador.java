
package controler;

import model.Usuario;
import model.Produto;

public class Administrador extends Usuario{

    public Administrador(String id, String email, String senha, String nome) {
        super(id, email, senha, nome);
    }

    @Override
    public void atualizarDados() {
        System.out.println("Atualiazando permissôes e dados do Administrador: " + super.getNome());
    }

    public void cadastrarProduto(Produto produto ){
        //fazer a lista de produtos aqui, depois que o Moíses terminar de fazer essa parte.
        System.out.println("Sucesso: Produto '" + produto.getNome() + "' cadastrado no sistema");
    }

    public void gerenciarEstoque(Produto produto, int novaQuantidade){
        produto.atualizarEstoque(novaQuantidade);

        System.out.println("O estoque do produto '" + produto.getNome() + "' foi atualizado para: " + novaQuantidade + " unidades.");
        
    }
    
}
