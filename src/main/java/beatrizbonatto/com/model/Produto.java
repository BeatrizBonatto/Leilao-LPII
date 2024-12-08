package beatrizbonatto.com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "sub_tipo", nullable = false, columnDefinition = "VARCHAR(255)")
    private SubTipo subTipo;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(name = "preco_inicial", nullable = false)
    private Double precoInicial;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "leilao_id", nullable = false)
    @JsonBackReference
    private Leilao leilao;

    public Produto() {}

    public Produto(Long id, SubTipo subTipo, String nome, String descricao, Double precoInicial,
                   Leilao leilao) {
        this.id = id;
        this.subTipo = subTipo;
        this.nome = nome;
        this.descricao = descricao;
        this.precoInicial = precoInicial;
        this.leilao = leilao;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String complemento) {
        this.descricao = complemento;
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

}
