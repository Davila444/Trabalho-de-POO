package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import model.Pedido;
import model.ItemCarrinho;
import model.ItemPedido;
import model.Produto; 

class PedidoTest {
    
    class ProdutoTeste extends Produto {
        public ProdutoTeste(String id, String nome, double preco, int estoque) {
            super(id, nome, preco, estoque);
        }
    }

    private Pedido pedido;
    private Produto produto;

    @BeforeEach
    void setup() {
        produto = new ProdutoTeste("1", "notebook", 2500, 10);
        pedido = new Pedido(1, LocalDate.of(2026, 6, 19), "Aguardando");
    }

    @Test
    void testCalcularTotal(){
        List<ItemCarrinho> itens = new ArrayList<>();
        itens.add(new ItemCarrinho(produto, 2)); 

        Pedido pedido = new Pedido(null, itens);
        
        double total = pedido.calcularTotal();

        assertEquals(5000.0, total);
    }
}
