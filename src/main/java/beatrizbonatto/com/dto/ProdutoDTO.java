package beatrizbonatto.com.dto;


import beatrizbonatto.com.model.Lance;
import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.model.SubTipo;

import java.util.List;

public class ProdutoDTO {
    private Long id;
    private SubTipo subTipo;
    private String complemento;
    private Double precoInicial;
    private Leilao leilao;
    private List<Lance> lances;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Long id, SubTipo subTipo, String complemento, Double precoInicial,
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

}
