package interfaces;

import model.Carrinho;
import model.Cliente;

public interface ILojaOnline {
    void cadastrarCliente(Cliente cliente);
    void listarProdutos();
    void criarPedido(Carrinho carrinho, Cliente cliente);
}



