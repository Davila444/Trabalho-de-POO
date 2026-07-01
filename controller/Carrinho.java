package controller;

import java.util.ArrayList;
import java.util.List;

import interfaces.IFazerCalculo;
import model.ItemCarrinho;

/**
 * Classe responsável por guardar os itens que o usuário pretende comprar.
 * */
public class Carrinho implements IFazerCalculo, ICarrinho {

    private List<ItemCarrinho> itens;

    public Carrinho () {
        this.itens = new ArrayList<ItemCarrinho>();
    }

        /**
         * Adiciona um item ao carrinho do cliente.
         * 
         * @param item item a ser adicionado no carrinho.
         */
        @Override
        public void adicionarItem(ItemCarrinho item) {
            this.itens.add(item);
    }

        /**
         * Remove um item pedido pelo cliente.
         * 
         * @param item item a ser removido no carrinho.
         */
        public void removerItem(ItemCarrinho item) {
            this.itens.remove(item);
    }
        @Override
        /**
         * Faz o calculo do valor a ser pago pelo cliente com aquele carrinho.
         * 
         * @return o valor total dos itens.
         */
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
