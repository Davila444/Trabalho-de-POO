package interfaces;

import model.Pedido;

public interface ICliente extends IUsuario{
    void adicionarPedido(Pedido pedido);
    void exibirHistorico();
}

