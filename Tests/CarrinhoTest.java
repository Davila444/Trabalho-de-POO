package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import controller.Carrinho;
import model.ItemCarrinho;
import model.Produto; 

/**
 * Testes unitários da classe Carrinho.
 */
class CarrinhoTest{

    class ProdutoTeste extends Produto {
        public ProdutoTeste(String id, String nome, double preco, int estoque) {
            super(id, nome, preco, estoque);
        }
    }

    private Carrinho carrinho;
    private Produto produto;

    @BeforeEach
    void setup(){
        carrinho = new Carrinho();
        produto = new ProdutoTeste("1", "Notebook", 2500,10);
    }
    /** Verifica se o item está sendo adicionado corretamente ao carrinho. */
    @Test
    void testAdicionarItem() {
        ItemCarrinho item = new ItemCarrinho(produto, 2);
        carrinho.adicionarItem(item);
        assertEquals(1, carrinho.getItens().size());
    }
    /** Verifica se o item está sendo removido do carrinho, como o esperado. */
    @Test
    void testRemoverItem() {
        ItemCarrinho item = new ItemCarrinho(produto, 2);
        carrinho.adicionarItem(item);
        carrinho.removerItem(item);
        assertTrue(carrinho.getItens().isEmpty());

    }
    /** Verifica se o total calculado da compra está sendo corretamente. */
    @Test
    void testCalcularTotal() {
        ItemCarrinho item = new ItemCarrinho(produto, 2);
        carrinho.adicionarItem(item);
        assertEquals(5000,0, carrinho.calcularTotal());
    }
}