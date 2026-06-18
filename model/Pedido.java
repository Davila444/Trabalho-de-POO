package model;
import java.time.LocalDate;
import java.util.List;

import interfaces.IFazerCalculo;

public class Pedido implements IFazerCalculo {

    private int idPedido;
    private LocalDate data;
    private String status;
    private Cliente cliente;
    private List<ItemCarrinho> itens;


    public Pedido(int idPedido, LocalDate data, String status) {
        this.idPedido = idPedido;
        this.data = data;
        this.status = status;
    }

    public Pedido(Cliente cliente, List<ItemCarrinho> itens) {
        this.cliente = cliente;
        this.itens = itens;
        this.data = LocalDate.now();
        this.status = "Pendente";

    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void gerarPedido(){
        this.status = "confirmado";
        System.out.println("Pedido gerado");
        System.out.println("Data: "+ this.data);
        System.out.println("Status: "+ this.status);
        System.out.println("itens: ");
        for (ItemCarrinho item : itens) {
            System.out.println("- " + item.getProduto().getNome());
        }
    }

    @Override
    public double calcularTotal() {
        double total = 0.0;
        return total;
    }
    
}