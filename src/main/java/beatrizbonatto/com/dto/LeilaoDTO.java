package beatrizbonatto.com.dto;

import beatrizbonatto.com.model.Produto;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class LeilaoDTO {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private LocalDateTime dataInicio;
    @Column(nullable = false)
    private LocalDateTime dataFim;
    @Column(nullable = false)
    private LocalDateTime dataVisitacao;
    @Column(nullable = false)
    private LocalDateTime dataEvento;
    @Column(nullable = false)
    private String dominioLeilaoEletronico;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String status;

    @OneToMany
    private List<Produto> produtos = new ArrayList<Produto>();

    public LeilaoDTO() {}

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
