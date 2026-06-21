package interfaces;

import model.Produto;

public interface IUsuario {
    void cadastrar();
    void login();
    void atualizarDados();
    void gerenciarEstoque(Produto produto, int novaQuantidade);
}
