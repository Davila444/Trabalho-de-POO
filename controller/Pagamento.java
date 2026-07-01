package controller;

import interfaces.IPagamento;

public class Pagamento implements IPagamento {
    private String id;
    private String metodo;
    private String status;
    /**
     * Classe responsável pelo gerenciamento de pagamento após a confirmação de pedido do cliente.
     */
    public Pagamento(String id, String metodo, String status) {
        this.id = id;
        this.metodo = metodo;
        this.status = "Pendente";
    }

    public String getId() {
        return id;
    }



    public void setId(String id) {
        this.id = id;
    }



    public String getMetodo() {
        return metodo;
    }



    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }



    public String getStatus() {
        return status;
    }



    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Responsável pelo processamento final do pagamento para a confirmação da compra.
     */
    @Override
    public void processarPagamento(){
        System.out.println("Aguarde o Processamento");
        System.out.println("Método: " +this.metodo);
        this.status = "Aprovado";
        System.out.println("Status: " + this.status);
        System.out.println("O pagamento foi Realizado");

    }

}
