package excessoes;


/**
 * Exceção lançada quando os dados passados no login *são inválidos, como um email ou/e uma senha que não *existem ou não condizem com nenhum úsuario.
 */
public class LoginInvalidoException extends RuntimeException {

    /**
     * @param mensagem mensagem com a descrição dos  *erro do login.
     */
    public LoginInvalidoException(String mensagem) {
        super(mensagem);
    }
}