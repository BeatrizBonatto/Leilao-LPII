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
    private String status;
    private Leilao leilao;
    private List<Lance> lances;

    public ProdutoDTO() {
    }

    public ProdutoDTO(SubTipo subTipo, String complemento, Double precoInicial,
                      String status, Leilao leilao, List<Lance> lances) {
        this.subTipo = subTipo;
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

    public String getStatus() {
        return status;
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
