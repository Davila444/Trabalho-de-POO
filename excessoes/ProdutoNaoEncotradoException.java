package excessoes;

/**
 * Exceção lançada quando o produto pedido não é *encontrado no estoque.
 */
public class ProdutoNaoEncotradoException extends RuntimeException{

    /**
     * @param mensagem mensagem de erro de produto não *encontrado.
     */
    public ProdutoNaoEncotradoException(String mensagem){
        super(mensagem);
    }
}