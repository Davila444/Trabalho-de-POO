package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import model.Cliente;
import model.Pedido;

/**
 * Testes unitários da classe Cliente.
 */
class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setup() {
        cliente = new Cliente("Jonas", "Jonas@email.com", "12345", "Rua B");
    }
    /** Verifica se a regra do sietema de toda cliente ser cadastrado já com um carrinho está sendo cumprida, ou seja, se ele não é nulo. */
    @Test
    void testCarrinhoNaoNulo() {
        assertNotNull(cliente.getCarrinho());
    }
    /** Verifica se o historico de cliente não "nasce junto com ele, o que não deve acontecer, já que um cliente recém criado não tem histórico de compra". */
    @Test
    void testHistoricoVazio() {
        assertTrue(cliente.getHistoricoPedido().isEmpty());
    }
    /** Verifica se um pedido está sendo adicionado corretamente quando solicitado pelo cliente. */
    @Test
    void testAdicionarPedido() {
        Pedido pedido = new Pedido(1, null, "Pendente");
        cliente.adicionarPedido(pedido);
        assertEquals(1, cliente.getHistoricoPedido().size());
    }
}
