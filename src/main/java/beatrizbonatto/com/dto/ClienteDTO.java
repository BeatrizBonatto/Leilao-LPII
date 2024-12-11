package beatrizbonatto.com.dto;

import beatrizbonatto.com.model.Lance;

import java.sql.Date;
import java.util.List;

public class ClienteDTO {
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private List<Lance> lances;

    public ClienteDTO(){}

    public ClienteDTO(String nome, String cpf, Date dataNascimento, List<Lance> lances) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.lances = lances;
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
