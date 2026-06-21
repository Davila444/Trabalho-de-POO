package excessoes;

public class EstoqueInvalidoException extends RuntimeException {
    public EstoqueInvalidoException(String mensagem) {
        super(mensagem);
    }
}