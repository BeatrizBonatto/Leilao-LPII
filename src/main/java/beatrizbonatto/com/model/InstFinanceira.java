package beatrizbonatto.com.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Inst_Financeira")
public class InstFinanceira {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long codigo;

    private String nome;

    @Column(unique=true)
    private String cnpj;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(name = "instfinanceira_leilao",
            joinColumns = @JoinColumn(name = "instfinanceira_id"),
            inverseJoinColumns = @JoinColumn(name = "leilao_id")
    )
    private List<Leilao> leiloes;

    public InstFinanceira() {}

    public InstFinanceira(Long id, Long codigo, String nome, String cnpj, List<Leilao> leiloes) {
        this.id = id;
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
