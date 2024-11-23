package beatrizbonatto.com.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "sub_tipo")
    private SubTipo subTipo;

    private String complemento;

    @Column(name = "preco_inicial")
    private Double precoInicial;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Leilao leilao;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn
    private List<Lance> lances;

    public Produto() {}

    public Produto(Long id, SubTipo subTipo, String complemento, Double precoInicial,
                   Leilao leilao, List<Lance> lances) {
        this.id = id;
        this.subTipo = subTipo;
        this.complemento = complemento;
        this.precoInicial = precoInicial;
        this.leilao = leilao;
        this.lances = lances;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SubTipo getSubTipo() {
        return subTipo;
    }

    public void setSubTipo(SubTipo subTipo) {
        this.subTipo = subTipo;
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
