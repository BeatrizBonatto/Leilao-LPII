package beatrizbonatto.com.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Produto {
    @Id
    @GeneratedValue
    private Long id;
    private String tipo;
    private String complemento;
    private Double precoInicial;
    private String status;

    @ManyToOne
    @JoinColumn(name = "leilao_id")
    private Leilao leilao;

    @ManyToMany
    @JoinTable(name = "produto_lance",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "lance_id"))
    private List<Lance> lances;

    public Produto() {}

    public Produto(String tipo, String complemento, Double precoInicial, String status, Leilao leilao, List<Lance> lances) {
        this.tipo = tipo;
        this.complemento = complemento;
        this.precoInicial = precoInicial;
        this.status = status;
        this.leilao = leilao;
        this.lances = lances;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Double getPrecoInicial() {
        return precoInicial;
    }

    public void setPrecoInicial(Double precoInicial) {
        this.precoInicial = precoInicial;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }

    public List<Lance> getLances() {
        return lances;
    }

    public void setLances(List<Lance> lances) {
        this.lances = lances;
    }
}
