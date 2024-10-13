package beatrizbonatto.com.dto;

import beatrizbonatto.com.model.Cliente;
import beatrizbonatto.com.model.Produto;

import java.util.List;

public class LanceDTO {
    private Long id;
    private List<Cliente> clientes;
    private List<Produto> produtos;
    private Double valor;

    public LanceDTO() {}

    public LanceDTO(List<Cliente> clientes, List<Produto> produtos, Double valor) {
        this.clientes = clientes;
        this.produtos = produtos;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
