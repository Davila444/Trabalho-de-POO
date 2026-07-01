package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Produto;
import excessoes.QuantidadeInvalidaException;

class ProdutoTest {

    class ProdutoTeste extends Produto {
        public ProdutoTeste(String id, String nome, double preco, int estoque) {
            super(id, nome, preco, estoque);
        }
    }

    private Produto produto;

    @BeforeEach
    void setup() {
        produto = new ProdutoTeste("1", "Notebook", 2500, 10);
    }

    
}
