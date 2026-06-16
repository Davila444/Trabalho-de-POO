package interfaces;

import model.ItemCarrinho;

public interface ICarrinho {
    void adicionarItem(ItemCarrinho item);
    void removerItem(ItemCarrinho item);
    void calcularTotal();
}

