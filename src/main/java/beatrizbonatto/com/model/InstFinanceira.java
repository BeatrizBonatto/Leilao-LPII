package beatrizbonatto.com.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class InstFinanceira {
    @Id
    @GeneratedValue
    private Long id;
    private Long codigo;
    private String nome;
    @Column(unique=true)
    private String cnpj;

    @ManyToMany(mappedBy = "instFinanceiras")
    private List<Leilao> leiloes = new ArrayList<>();

    public InstFinanceira() {}

    public InstFinanceira(Long codigo, String nome, String cnpj, List<Leilao> leiloes) {
        this.codigo = codigo;
        this.nome = nome;
        this.cnpj = cnpj;
        this.leiloes = leiloes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Leilao> getLeiloes() {
        return leiloes;
    }

    public void setLeiloes(List<Leilao> leiloes) {
        this.leiloes = leiloes;
    }
}
