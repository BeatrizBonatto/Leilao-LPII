package beatrizbonatto.com.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "leilao_id")
    private Leilao leilao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "produto_lance",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "lance_id"))
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
