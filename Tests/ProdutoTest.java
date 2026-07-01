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

    @Test
    void testRemoverDoEstoqueValido() {
        produto.removerDoEstoque(3);
        assertEquals(7, produto.getEstoque());
    }

    @Test
    void testRemoverDoEstoqueZero() {
        assertThrows(QuantidadeInvalidaException.class, () -> {
            produto.removerDoEstoque(0);
        });
    }

    @Test
    void testRemoverDoEstoqueInsuficiente() {
        assertThrows(QuantidadeInvalidaException.class, () -> {
            produto.removerDoEstoque(20);
        });
    }

    @Test
    void testAtualizarEstoque() {
        produto.atualizarEstoque(50);
        assertEquals(50, produto.getEstoque());
    }
}
