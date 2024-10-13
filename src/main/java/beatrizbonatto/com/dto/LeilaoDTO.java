package beatrizbonatto.com.dto;

import beatrizbonatto.com.model.Produto;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class LeilaoDTO {

    private int id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private LocalDateTime dataVisitacao;
    private LocalDateTime dataEvento;
    private String dominioLeilaoEletronico;
    private String endereco;
    private String cidade;
    private String estado;
    private String status;

    @OneToMany
    private List<Produto> produtos = new ArrayList<Produto>();

    public LeilaoDTO(LocalDateTime dataInicio, LocalDateTime dataFim, LocalDateTime dataVisitacao, LocalDateTime dataEvento, String dominioLeilaoEletronico, String endereco, String cidade, String estado, String status) {}

    public LeilaoDTO(LocalDateTime dataInicio, LocalDateTime dataFim, LocalDateTime dataVisitacao, LocalDateTime dataEvento,
                     String dominioLeilaoEletronico,
                     String endereco, String cidade, String estado,
                     String status, List<Produto> produtos) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataVisitacao = dataVisitacao;
        this.dataEvento = dataEvento;
        this.dominioLeilaoEletronico = dominioLeilaoEletronico;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.status = status;
        this.produtos = produtos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public LocalDateTime getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDateTime dataEvento) {
        this.dataEvento = dataEvento;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
