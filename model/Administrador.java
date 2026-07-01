
package model;

import excessoes.EstoqueInvalidoException;
import interfaces.IAdministrador;


/**
     * Classe reponsável pelo gerenciamento da loja em relação à atualização de dados, cadastro de produtos e gerenciamento de estoque.
     */

public class Administrador extends Usuario implements IAdministrador{

    public Administrador(String id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    @Override
    /**
     * Método que atualiza os dados dos administradores.
     */
    public void atualizarDados() {
        System.out.println("Atualiazando permissôes e dados do Administrador: " + super.getNome());
    }

    @Override
    /**
     * Método para o cadastramento de produtos no sistema pelo administrador.
     */
    public void cadastrarProduto(Produto produto){
        System.out.println("Sucesso: Produto '" + produto.getNome() + "' cadastrado no sistema");
    }

    /**
     * Método para gerenciamento do estoque de produtos e atualização quando necessário (quando os produtos são reabastecidos).
     * 
     * @param produto produto a ser gerenciado no estoque
     * @param novaQuantidade novaQuantidade a ser colocada no estoque.
     * @throws EstoqueInvalidoException para verificar se o reabastecimento é negativo, o que não pode ser aceito.
     * 
     *
     */
    @Override
    public void gerenciarEstoque(Produto produto, int novaQuantidade){
        if (novaQuantidade < 0) {
            throw new EstoqueInvalidoException("Estoque invalido: " + novaQuantidade + "nao pode ser negativa");
        }
        produto.atualizarEstoque(novaQuantidade);
        System.out.println("O estoque do produto '" + produto.getNome() + "' foi atualizado para: " + novaQuantidade + " unidades.");
        
        }
    @Override
    public void cadastrar() {
        System.out.println();
    }
    @Override
    public void login() {

    }
    
}
