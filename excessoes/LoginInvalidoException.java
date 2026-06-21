package excessoes;

public class LoginInvalidoException extends RuntimeException {
    public LoginInvalidoException(String mensagem) {
        super(mensagem);
    }
}