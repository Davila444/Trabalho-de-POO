package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import controller.Pagamento;


 class PagamentoTest {
    private Pagamento pagamento;

    @BeforeEach
    void setup(){
        pagamento = new Pagamento("1", "pix", "Pendente");
    }

    @Test
    void testprocessarPagamento(){
        pagamento.processandoPagamento();
        assertEquals("Aprovado", pagamento.getStatus());
    }


}
