package beatrizbonatto.com.model;

import beatrizbonatto.com.dto.VeiculoDTO;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.locationtech.jts.geom.impl.PackedCoordinateSequence.Double;

import jakarta.persistence.Entity;

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
    private Double kmRodados;
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

    VeiculoDTO veiculoDTO() {
        VeiculoDTO veiculoDTO = new VeiculoDTO();
        veiculoDTO.setId(id);
        veiculoDTO.setTipoVeiculo(tipoVeiculo);
        veiculoDTO.setMarca(marca);
        veiculoDTO.setModelo(modelo);
        veiculoDTO.setAno(ano);
        veiculoDTO.setCor(cor);
        veiculoDTO.setPlaca(placa);
        return veiculoDTO;
    }
}
