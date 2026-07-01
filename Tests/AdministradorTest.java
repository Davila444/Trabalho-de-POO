package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import model.Administrador;
import model.Produto;
import excessoes.EstoqueInvalidoException;

class AdministradorTest {
    class ProdutoTeste extends Produto {
        public ProdutoTeste(String id, String nome, double preco, int estoque) {
            super(id, nome, preco, estoque);
        }
    }
    
    private Administrador admin;
    private Produto produto;

    @BeforeEach
    void setup() {
        admin = new Administrador("1", "Admin", "admin@email.com", "123");
        produto = new ProdutoTeste("1", "Notebook", 2500, 10);
    }

    @Test
    void testGerenciarEstoqueValido() {
        admin.gerenciarEstoque(produto, 20);
        assertEquals(20, produto.getEstoque());
    }

    @Test
    void testGerenciarEstoqueInvalido() {
        assertThrows(EstoqueInvalidoException.class, () -> {
            admin.gerenciarEstoque(produto, -1);
        });
    }
}
