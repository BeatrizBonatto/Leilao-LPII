package beatrizbonatto.com.dto;

import beatrizbonatto.com.model.Leilao;

import java.util.List;

public class DetalhesLeilaoDTO {
    //lista de produtos
    private List<String> produtos;
    //bancos
    private List<String> instFinanceiras;
    //dados do leilão
    private Leilao leilao;
    //quantidade de produtos
    private Integer quantidadeProdutos;

    public DetalhesLeilaoDTO(List<String> produtos, List<String> instFinanceiras, Leilao leilao, Integer quantidadeProdutos) {
        this.produtos = produtos;
        this.instFinanceiras = instFinanceiras;
        this.leilao = leilao;
        this.quantidadeProdutos = quantidadeProdutos;
    }

    public List<String> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<String> produtos) {
        this.produtos = produtos;
    }

    public List<String> getInstFinanceiras() {
        return instFinanceiras;
    }

    public void setInstFinanceiras(List<String> instFinanceiras) {
        this.instFinanceiras = instFinanceiras;
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }

    public Integer getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    public void setQuantidadeProdutos(Integer quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }
}
