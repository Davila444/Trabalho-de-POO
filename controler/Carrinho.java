package controler;

import java.util.ArrayList;
import java.util.List;

import interfaces.IFazerCalculo;
import model.ItemCarrinho;

public class Carrinho implements IFazerCalculo {

    private List<ItemCarrinho> itens;

    public Carrinho() {
        this.itens = new ArrayList<ItemCarrinho>();
    }
        public void adicionarItem(ItemCarrinho item) {
            this.itens.add(item);
    }

        public void removerItem(ItemCarrinho item) {
            this.itens.remove(item);
    }
        @Override
        public double calcularTotal() {
            double total = 0.0;
            
            for (ItemCarrinho item : itens) {
                total += item.getQuantidade() * item.getProduto().getPreco();
        }

            return total;
        }
        public List<ItemCarrinho> getItens() {
            return itens;
        }
}
