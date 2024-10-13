package beatrizbonatto.com.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Lance {
    @Id
    @GeneratedValue
    private Long id;
    private Double valor;

    @ManyToMany
    @JoinTable(name = "lance_cliente",
            joinColumns = @JoinColumn(name = "lance_id"),
            inverseJoinColumns = @JoinColumn(name = "clienteo_id"))
    private List<Cliente> clientes;

    @ManyToMany
    @JoinTable(name = "lance_produto",
            joinColumns = @JoinColumn(name = "lance_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produtos;

    public Lance() {}

    public Lance(List<Cliente> clientes, List<Produto> produtos, Double valor) {
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
