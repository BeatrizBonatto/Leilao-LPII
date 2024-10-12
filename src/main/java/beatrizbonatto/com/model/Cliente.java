package beatrizbonatto.com.model;

import beatrizbonatto.com.dto.ClienteDTO;

import java.sql.Date;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String celular;
    private String email;
    private Date dataNascimento;

    public Cliente(){}

    public Cliente(String nome, String cpf, String celular, String email, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    ClienteDTO clienteDTO(){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNome(nome);
        clienteDTO.setCpf(cpf);
        clienteDTO.setCelular(celular);
        clienteDTO.setEmail(email);
        clienteDTO.setDataNascimento(dataNascimento);
        return clienteDTO;
    }
}
