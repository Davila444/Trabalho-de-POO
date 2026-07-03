package excessoes;

/**
 * Exceção lançada quando a quantidade pedida pelo *cliente para a compra é inválida, como por exemplo *valores negativos.
 */
public class QuantidadeInvalidaException extends RuntimeException {

    /**
     * @param mensagem mensagem com a descrição do *erro de quantidade inválida informada pelo *cliente
     */
    public QuantidadeInvalidaException(String mensagem) {
        super(mensagem);
    }
}
