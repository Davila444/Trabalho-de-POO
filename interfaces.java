
// INTERFACES DOS USUÁRIOS

public interface IUsuario {
    void cadastrar();
    void login();
    void atualizarDados();
}

public interface IAdministrador extends IUsuario {
    void cadastrarProduto();
    void gerenciarEstoque();
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
    void calcularTotal();
}

public interface IPagamento {
    void processandoPagamento();
}
