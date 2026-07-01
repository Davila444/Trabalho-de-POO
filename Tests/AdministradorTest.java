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

    
}
