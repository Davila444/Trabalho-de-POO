package model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho implements FazerCalculo {

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
