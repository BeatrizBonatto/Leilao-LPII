package beatrizbonatto.com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class DispInformatica extends Produto {
    @Id
    @GeneratedValue
    private Long id;
    private TipoDispositivo tipoDispositivo;
    private String marca;
    private String modelo;

    public DispInformatica() {
    }

    public DispInformatica(Long id, String tipo, String descricao, Double precoInicial, String status, Leilao leilao, List<Lance> lances,
                           TipoDispositivo tipoDispositivo, String marca, String modelo) {
        super("Dispositivo de Informática", descricao, precoInicial, status, leilao, lances);
        this.tipoDispositivo = tipoDispositivo;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoDispositivo getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
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

}
