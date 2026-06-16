package interfaces;

import model.Pedido;

public interface ICliente extends IUsuario{
    void atualizarDados(Pedido pedido);
    void cadastrar();
}

