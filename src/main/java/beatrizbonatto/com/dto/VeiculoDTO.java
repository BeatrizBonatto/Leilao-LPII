package beatrizbonatto.com.dto;

import beatrizbonatto.com.model.TipoVeiculo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Schema(description = "Veiculo a ser leiloado")
public class VeiculoDTO {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private TipoVeiculo tipoVeiculo;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false)
    private String cor;

    @Column(nullable = false)
    private Double kmRodados;

    @Column(nullable = false)
    private String placa;

    public VeiculoDTO() {
    }

    public VeiculoDTO(TipoVeiculo tipoVeiculo, String marca, String modelo, Integer ano, String cor, Double kmRodados, String placa) {
        this.tipoVeiculo = tipoVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.kmRodados = kmRodados;
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

    public Double getKmRodados() {
        return kmRodados;
    }

    public void setKmRodados(Double kmRodados) {
        this.kmRodados = kmRodados;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
