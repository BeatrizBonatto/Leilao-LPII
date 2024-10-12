package beatrizbonatto.com.model;

import jakarta.persistence.Column;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import jakarta.persistence.Entity;

@Entity
@Schema(description = "Dispositivo de Informatica a ser leiloado")
public class DispInformatica extends Produto {
    @Column(nullable = false)
    private TipoDispositivo tipoDispositivo;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String modelo;

    public DispInformatica() {
    }

    public DispInformatica(Long id, String tipo, String descricao, Double precoInicial, Leilao leilao,
            TipoDispositivo tipoDispositivo, String marca, String modelo, String serie) {
        super("Dispositivo de Informarica", descricao, precoInicial, leilao);
        this.tipoDispositivo = tipoDispositivo;
        this.marca = marca;
        this.modelo = modelo;
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
