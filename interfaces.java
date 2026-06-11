// INTERFACES DO SISTEMA

public interface IFazerCalculo {
    double calcularTotal();
}

public interface Ipagamento {
    void processandoPagamento(double valor);
}
