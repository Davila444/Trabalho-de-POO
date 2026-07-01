package interfaces;


import model.Cliente;
import model.Produto;
import java.util.Scanner;

public interface ILojaOnline {
    void cadastrarCliente(Scanner scanner);
    Produto buscarProduto(String nome);
    void criarPedido(Cliente cliente);
    void listarProdutos();
}



