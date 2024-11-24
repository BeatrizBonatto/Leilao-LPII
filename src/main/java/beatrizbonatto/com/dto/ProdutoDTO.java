package beatrizbonatto.com.dto;


import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.model.SubTipo;

public class ProdutoDTO {
    private Long id;
    private SubTipo subTipo;
    private String descricao;
    private Double precoInicial;
    private Leilao leilao;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Long id, SubTipo subTipo, String descricao, Double precoInicial,
                      Leilao leilao) {
        this.id = id;
        this.subTipo = subTipo;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
