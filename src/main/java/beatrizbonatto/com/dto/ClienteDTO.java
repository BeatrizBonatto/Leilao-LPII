package beatrizbonatto.com.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class ClienteDTO {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String celular;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Date dataNascimento;

    public ClienteDTO(){}

    public ClienteDTO(String nome, String cpf, String celular, String email, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
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

}
