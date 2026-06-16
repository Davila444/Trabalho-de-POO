package interfaces;

import model.Produto;

public interface IAdministrador extends IUsuario {
    void cadastrarProduto(Produto produto);
    void gerenciarEstoque(Produto produto, int novaQuantidade);
}
