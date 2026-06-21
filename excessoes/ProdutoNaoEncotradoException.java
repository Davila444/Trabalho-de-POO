package excessoes;

public class ProdutoNaoEncotradoException extends RuntimeException{
    public ProdutoNaoEncotradoException(String mensagem){
        super(mensagem);
    }
}