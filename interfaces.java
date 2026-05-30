
// INTERFACES DO SISTEMA

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