package beatrizbonatto.com.dto;

import beatrizbonatto.com.model.Lance;

import java.sql.Date;
import java.util.List;

public class ClienteDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String celular;
    private String email;
    private Date dataNascimento;
    private List<Lance> lances;

    public ClienteDTO(){}

    public ClienteDTO(String nome, String cpf, String celular, String email, Date dataNascimento, List<Lance> lances) {
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.lances = lances;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Lance> getLances() {
        return lances;
    }

    public void setLances(List<Lance> lances) {
        this.lances = lances;
    }
}
