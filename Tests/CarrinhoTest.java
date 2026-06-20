package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import controller.Carrinho;
import model.ItemCarrinho;
import model.Produto; 

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

    @Test
    void testAdicionarItem() {
        ItemCarrinho item = new ItemCarrinho(produto, 2);
        carrinho.adicionarItem(item);
        assertEquals(1, carrinho.getItens().size());
    }

    @Test
    void testRemoverItem() {
        ItemCarrinho item = new ItemCarrinho(produto, 2);
        carrinho.adicionarItem(item);
        carrinho.removerItem(item);
        assertTrue(carrinho.getItens().isEmpty());

    }

    @Test
    void testCalcularTotal() {
        ItemCarrinho item = new ItemCarrinho(produto, 2);
        carrinho.adicionarItem(item);
        assertEquals(5000,0, carrinho.calcularTotal());
    }
}