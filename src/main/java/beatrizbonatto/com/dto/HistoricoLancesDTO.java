package beatrizbonatto.com.dto;

public class HistoricoLancesDTO {
    private int id;
    private String produto;
    private String cliente;
    private Double valor;

    public HistoricoLancesDTO(int id, String produto, String cliente, Double valor) {
        this.id = id;
        this.produto = produto;
        this.cliente = cliente;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
