package beatrizbonatto.com.dto;

import beatrizbonatto.com.model.Produto;

import java.time.LocalDateTime;
import java.util.List;


public class LeilaoDTO {
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private LocalDateTime dataVisitacao;
    private String dominioLeilaoEletronico;
    private String endereco;
    private String cidade;
    private String estado;
    private List<Long> listIdsInstFin;

    public LeilaoDTO() {}

    public LeilaoDTO(LocalDateTime dataInicio, LocalDateTime dataFim, LocalDateTime dataVisitacao,
                     String dominioLeilaoEletronico,
                     String endereco, String cidade, String estado,
                     List<Long> listIdsInstFin) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataVisitacao = dataVisitacao;
        this.dominioLeilaoEletronico = dominioLeilaoEletronico;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.listIdsInstFin = listIdsInstFin;
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

    public List<Long> getListIdsInstFin() {
        return listIdsInstFin;
    }

    public void setListIdsInstFin(List<Long> listIdsInstFin) {
        this.listIdsInstFin = listIdsInstFin;
    }
}
