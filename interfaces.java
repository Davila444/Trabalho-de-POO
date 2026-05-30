
// INTERFACES DO SISTEMA

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