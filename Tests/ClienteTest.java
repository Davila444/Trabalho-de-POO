package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import model.Cliente;
import model.Pedido;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setup() {
        cliente = new Cliente("Jonas", "Jonas@email.com", "12345", "Rua B");
    }

    @Test
    void testCarrinhoNaoNulo() {
        assertNotNull(cliente.getCarrinho());
    }

}
