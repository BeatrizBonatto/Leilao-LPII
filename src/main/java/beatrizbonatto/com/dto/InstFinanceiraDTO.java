package beatrizbonatto.com.dto;

import beatrizbonatto.com.model.Lance;
import beatrizbonatto.com.model.Leilao;

import java.util.List;

public class InstFinanceiraDTO {
    private Long id;
    private Long codigo;
    private String nome;
    private String cnpj;
    private List<Leilao> leiloes;

    public InstFinanceiraDTO(Long codigo, String nome, String cnpj, List<Leilao> leiloes) {}

    public InstFinanceiraDTO(Long id, Long codigo, String nome, String cnpj, List<Leilao> leiloes) {
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
