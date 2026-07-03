package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import model.Administrador;
import model.Produto;
import excessoes.EstoqueInvalidoException;

/**
 * Testes unitários da classe Administrador.
 */
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
        admin = new Administrador("Admin", "admin@email.com", "123", "Rua A");
        produto = new ProdutoTeste("1", "Notebook", 2500, 10);
    }
    /** Verifica se a excessão está sendo lançada em caso de tentativa cadastramento de nova quantidade no estoque inválida(com números negativos, por exemplo). */
    @Test
    void testGerenciarEstoqueInvalido() {
        assertThrows(EstoqueInvalidoException.class, () -> {
            admin.gerenciarEstoque(produto, -1);
        });
    }
    /** Verifica se o estoque foi atualizado corretamente. */
    @Test
    void testGerenciarEstoqueValido() {
        admin.gerenciarEstoque(produto, 20);
        assertEquals(20, produto.getEstoque());
    }
    /** Verifica se o autenticar está retornado o True, que é o esperado. */
    @Test
    void testAutenticar() {
        boolean resultado = admin.Autenticar();
        assertTrue(resultado);
    }
}