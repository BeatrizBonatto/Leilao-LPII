package beatrizbonatto.com.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Leilao {
    @Id
    @GeneratedValue
    private int id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private LocalDateTime dataVisitacao;
    private LocalDateTime dataEvento;
    private String dominioLeilaoEletronico;
    private String endereco;
    private String cidade;
    private String estado;

    @OneToMany(mappedBy = "leilao")
    private List<Produto> produtos = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "leilao_instfinanceira",
            joinColumns = @JoinColumn(name = "leilao_id"),
            inverseJoinColumns = @JoinColumn(name = "instfinanceira_id")
    )
    private List<InstFinanceira> instFinanceiras = new ArrayList<>();

    public Leilao() {}

    public Leilao(LocalDateTime dataInicio, LocalDateTime dataFim, LocalDateTime dataVisitacao,
                  LocalDateTime dataEvento, String dominioLeilaoEletronico, String endereco,
                  String cidade, String estado, List<Produto> produtos, List<InstFinanceira> instFinanceiras) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataVisitacao = dataVisitacao;
        this.dataEvento = dataEvento;
        this.dominioLeilaoEletronico = dominioLeilaoEletronico;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.produtos = produtos;
        this.instFinanceiras = instFinanceiras;
    }

    public long getId() {
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

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<InstFinanceira> getInstFinanceiras() {
        return instFinanceiras;
    }

    public void setInstFinanceiras(List<InstFinanceira> instFinanceiras) {
        this.instFinanceiras = instFinanceiras;
    }
}
