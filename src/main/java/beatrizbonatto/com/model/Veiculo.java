package beatrizbonatto.com.model;

import jakarta.persistence.Column;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.locationtech.jts.geom.impl.PackedCoordinateSequence.Double;

import jakarta.persistence.Entity;

@Entity
@Schema(description = "Veiculo a ser leiloado")
public class Veiculo extends Produto {
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

    public Veiculo() {
    }

    public Veiculo(Long id, String tipo, String descricao, java.lang.Double precoInicial, Leilao leilao,
            TipoVeiculo tipoVeiculo, String marca, String modelo, Integer ano, String cor, Double km_rodados, String placa) {
        super("Veiculo", descricao, precoInicial, leilao);
        this.tipoVeiculo = tipoVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.kmRodados = km_rodados;
        this.placa = placa;
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
    public void setKmRodados(Double km_rodados) {
        this.kmRodados = km_rodados;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

}
