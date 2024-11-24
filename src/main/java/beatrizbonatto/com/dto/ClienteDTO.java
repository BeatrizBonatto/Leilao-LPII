package beatrizbonatto.com.dto;

import beatrizbonatto.com.model.Lance;

import java.sql.Date;
import java.util.List;

public class ClienteDTO {
    private Long id;
    private String nome;
    private String cpf;
    private Date dataNascimento;

    public ClienteDTO(){}

    public ClienteDTO(String nome, String cpf, Date dataNascimento, List<Lance> lances) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
