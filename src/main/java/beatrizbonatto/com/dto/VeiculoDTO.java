package beatrizbonatto.com.dto;

import beatrizbonatto.com.model.TipoVeiculo;

public class VeiculoDTO {

    private Long id;
    private TipoVeiculo tipoVeiculo;
    private String marca;
    private String modelo;
    private Integer ano;
    private String cor;
    private String placa;

    public VeiculoDTO(TipoVeiculo tipoVeiculo, String marca, String modelo, Integer ano, String cor, String placa) {
    }

    public VeiculoDTO(TipoVeiculo tipoVeiculo, String marca, String modelo, Integer ano, String cor, Double kmRodados, String placa) {
        this.tipoVeiculo = tipoVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.placa = placa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
