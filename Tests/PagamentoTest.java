package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import controller.Pagamento;

/**
 * Testes unitários da classe Pagamento.
 */
 class PagamentoTest {
    private Pagamento pagamento;

    @BeforeEach
    void setup(){
        pagamento = new Pagamento("1", "pix", "Pendente");
    }
    /** Verifica se um pagamento está sendo processado corretamente, mudando o seu status de pendente para aprovado. */
    @Test
    void testprocessarPagamento(){
        pagamento.processarPagamento();
        assertEquals("Aprovado", pagamento.getStatus());
    }


}
