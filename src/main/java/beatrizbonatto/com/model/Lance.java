package beatrizbonatto.com.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Lance")
public class Lance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Cliente cliente;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Produto produto;

    private Double valor;

    public Lance() {}

    public Lance(Long id, Cliente cliente, Produto produto, Double valor) {
        this.id = id;
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

    public void setCliente(Cliente clientes) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produtos) {
        this.produto = produto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
