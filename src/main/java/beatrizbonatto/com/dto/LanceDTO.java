package beatrizbonatto.com.dto;

import beatrizbonatto.com.model.Cliente;
import beatrizbonatto.com.model.Produto;

public class LanceDTO {
    private Long id;
    private Cliente cliente;
    private Produto produto;
    private Double valor;

    public LanceDTO() {}

    public LanceDTO(Long id, Cliente cliente, Produto produto, Double valor) {
        this.id = cliente.getId();
        this.cliente = cliente;
        this.produto = produto;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
