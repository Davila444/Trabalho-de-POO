package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Produto;
import excessoes.QuantidadeInvalidaException;

/**
 * Testes unitários da classe Produto.
 */
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
    /** Verifica se a quantidade tirada do estoque está correta e se o estoque fica com a quantiadade esperada. */
    @Test
    void testRemoverDoEstoqueValido() {
        produto.removerDoEstoque(3);
        assertEquals(7, produto.getEstoque());
    }
    /** Verifica se a excessão está sendo lançada em caso de tentativa de compra com 0 produtos. */
    @Test
    void testRemoverDoEstoqueZero() {
        assertThrows(QuantidadeInvalidaException.class, () -> {
            produto.removerDoEstoque(0);
        });
    }
    /** Verifica se a excessão está sendo lançada em caso de tentativa de compra de uma quantidade que não há no estoque. */
    @Test
    void testRemoverDoEstoqueInsuficiente() {
        assertThrows(QuantidadeInvalidaException.class, () -> {
            produto.removerDoEstoque(20);
        });
    }
    /** Verifica se o estoque está sendo atualizado corretamente. */
    @Test
    void testAtualizarEstoque() {
        produto.atualizarEstoque(50);
        assertEquals(50, produto.getEstoque());
    }
}
