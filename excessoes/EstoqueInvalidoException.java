package excessoes;

/**
 * Exceção lançada quando o o quantidade informada no estoque é inválida.
 */
public class EstoqueInvalidoException extends RuntimeException {

    /**
     * @param mensagem mensagem com a descrição do *erro de estoque inválido
     */
    public EstoqueInvalidoException(String mensagem) {
        super(mensagem);
    }
}