package view;

import java.time.LocalDate;

public class Pedido implements FazerCalculo {

    private int idPedido;
    private LocalDate data;
    private String status;

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

    }

    @Override
    public double calcularTotal() {
        double total = 0.0;
        return total;
    }
    
}