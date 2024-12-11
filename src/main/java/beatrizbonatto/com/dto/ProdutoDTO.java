package beatrizbonatto.com.dto;


import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.model.SubTipo;

public class ProdutoDTO {
    private String nome;
    private String descricao;
    private Double precoInicial;
    private Long idLeilao;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String nome, String descricao, Double precoInicial,
                      Long idLeilao) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoInicial = precoInicial;
        this.idLeilao = idLeilao;
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

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrecoInicial() {
        return precoInicial;
    }

    public void setPrecoInicial(Double precoInicial) {
        this.precoInicial = precoInicial;
    }

    public Long getIdLeilao() {
        return idLeilao;
    }

    public void setIdLeilao(Long idLeilao) {
        this.idLeilao = idLeilao;
    }
}
