public class Pagamento {
    private String id;
    private String metodo;
    private String status;

    public Pagamento(String id, String metodo, String status) {
        this.id = id;
        this.metodo = metodo;
        this.status = status;
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



    public void processandoPagamento(){

    }

}
