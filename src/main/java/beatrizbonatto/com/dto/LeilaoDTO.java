package beatrizbonatto.com.dto;

import beatrizbonatto.com.model.InstFinanceira;
import beatrizbonatto.com.model.Produto;

import java.time.LocalDateTime;
import java.util.List;


public class LeilaoDTO {

    private Long id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private LocalDateTime dataVisitacao;
    private String dominioLeilaoEletronico;
    private String endereco;
    private String cidade;
    private String estado;
    private List<Produto> produtos;
    private List<InstFinanceira> instFinanceira;

    public LeilaoDTO() {}

    public LeilaoDTO(Long id,
                     LocalDateTime dataInicio, LocalDateTime dataFim, LocalDateTime dataVisitacao,
                     String dominioLeilaoEletronico,
                     String endereco, String cidade, String estado,
                     List<Produto> produtos, List<InstFinanceira> instFinanceira) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataVisitacao = dataVisitacao;
        this.dominioLeilaoEletronico = dominioLeilaoEletronico;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.produtos = produtos;
        this.instFinanceira = instFinanceira;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public LocalDateTime getDataVisitacao() {
        return dataVisitacao;
    }

    public void setDataVisitacao(LocalDateTime dataVisitacao) {
        this.dataVisitacao = dataVisitacao;
    }

    public String getDominioLeilaoEletronico() {
        return dominioLeilaoEletronico;
    }

    public void setDominioLeilaoEletronico(String dominioLeilaoEletronico) {
        this.dominioLeilaoEletronico = dominioLeilaoEletronico;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<InstFinanceira> getInstFinanceira() {
        return instFinanceira;
    }

    public void setInstFinanceira(List<InstFinanceira> instFinanceira) {
        this.instFinanceira = instFinanceira;
    }

}
