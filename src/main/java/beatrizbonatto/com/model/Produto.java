package beatrizbonatto.com.model;

import jakarta.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
public class Produto {
    @Id
    @GeneratedValue
    private Long id;
    private String tipo;
    private String complemento;
    private Double precoInicial;

    @ManyToOne
    @JoinColumn(name = "leilao_id")
    private Leilao leilao;

    public Produto() {
    }

    public Produto(String tipo, String complemento, Double precoInicial, Leilao leilao) {
        this.tipo = tipo;
        this.complemento = complemento;
        this.precoInicial = precoInicial;
        this.leilao = leilao;
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

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }
    
}
