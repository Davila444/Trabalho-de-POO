// INTERFACES DOS USUÁRIOS
package view; 
public interface IUsuario {
    void cadastrar();
    void login();
    void atualizarDados();
}

public interface IAdministrador {
    void cadastrarProduto();
    void gerenciarEstoque();
}

public interface ICliente {
    void atualizarDados();
    void cadastrar();
}


// INTERFACES DO SISTEMA


public interface ILojaOnline {
    void cadastrarCliente();
    void listarProdutos();
    void criarPedido();
}

public interface IProduto {
    void atualizarEstoque();
}

public interface ICarrinho {
    void adicionarItem();
    void removerItem();
    void calcularTotal();
}

public interface IPedido {
    void gerarPedido();
    double calcularTotal();
}

public interface IPagamento {
    void processandoPagamento(double valor);
}


