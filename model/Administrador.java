
package model;
import excessoes.EstoqueInvalidoException;

public class Administrador extends Usuario{

    public Administrador(String id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    @Override
    public void atualizarDados() {
        System.out.println("Atualiazando permissôes e dados do Administrador: " + super.getNome());
    }

    @override
    public void cadastrarProduto(Produto produto){
        
        System.out.println("Sucesso: Produto '" + produto.getNome() + "' cadastrado no sistema");
    }

    @Override
    public void gerenciarEstoque(Produto produto, int novaQuantidade){
        if (novaQuantidade < 0) {
            throw new EstoqueInvalidoException("Estoque invalido: " + novaQuantidade + "nao pode ser negativa");
    }

        
        produto.atualizarEstoque(novaQuantidade);

        System.out.println("O estoque do produto '" + produto.getNome() + "' foi atualizado para: " + novaQuantidade + " unidades.");
        
        }
    
}
