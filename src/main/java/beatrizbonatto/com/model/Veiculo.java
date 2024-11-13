package beatrizbonatto.com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.locationtech.jts.geom.impl.PackedCoordinateSequence.Double;

import java.util.List;

@Entity
public class Veiculo extends Produto {
    @Id
    @GeneratedValue
    private Long id;
    private TipoVeiculo tipoVeiculo;
    private String marca;
    private String modelo;
    private Integer ano;
    private String cor;
    private double kmRodados;
    private String placa;

    public Veiculo() {
    }

    public Veiculo(Long id, String tipo, String descricao, java.lang.Double precoInicial, String status, Leilao leilao, List<Lance> lances,
            TipoVeiculo tipoVeiculo, String marca, String modelo, Integer ano, String cor, double kmRodados, String placa) {
        super("Veiculo", descricao, precoInicial, status, leilao, lances);
        this.tipoVeiculo = tipoVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.kmRodados = kmRodados;
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

    public double getKmRodados() {
        return kmRodados;
    }

    public void setKmRodados(double kmRodados) {
        this.kmRodados = kmRodados;
    }

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

}
