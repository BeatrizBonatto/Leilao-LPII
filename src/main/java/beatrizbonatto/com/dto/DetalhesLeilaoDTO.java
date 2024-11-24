package beatrizbonatto.com.dto;

import beatrizbonatto.com.model.Leilao;

import java.time.LocalDateTime;
import java.util.List;

public class DetalhesLeilaoDTO {
    private Long leilaoId;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private LocalDateTime dataVisita;
    private String dominioLeilaoEletronico;
    private String endereco;
    private String cidade;
    private String estado;
    private List<String> produtos;
    private List<String> instituicoesFinanceiras;
    private Integer quantidadeProdutos;
    private String status;

    public DetalhesLeilaoDTO(Long leilaoId, LocalDateTime dataInicio, LocalDateTime dataFim, LocalDateTime dataVisita,
                             String dominioLeilaoEletronico, String endereco, String cidade, String estado,
                             List<String> produtos, List<String> instituicoesFinanceiras, Integer quantidadeProdutos, String status) {
        this.leilaoId = leilaoId;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataVisita = dataVisita;
        this.dominioLeilaoEletronico = dominioLeilaoEletronico;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.produtos = produtos;
        this.instituicoesFinanceiras = instituicoesFinanceiras;
        this.quantidadeProdutos = quantidadeProdutos;
        this.status = status;
    }

    public Long getLeilaoId() {
        return leilaoId;
    }

    public void setLeilaoId(Long leilaoId) {
        this.leilaoId = leilaoId;
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

    public LocalDateTime getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(LocalDateTime dataVisita) {
        this.dataVisita = dataVisita;
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

    public List<String> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<String> produtos) {
        this.produtos = produtos;
    }

    public List<String> getInstituicoesFinanceiras() {
        return instituicoesFinanceiras;
    }

    public void setInstituicoesFinanceiras(List<String> instituicoesFinanceiras) {
        this.instituicoesFinanceiras = instituicoesFinanceiras;
    }

    public Integer getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    public void setQuantidadeProdutos(Integer quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
