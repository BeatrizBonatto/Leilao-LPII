package beatrizbonatto.com.dto;

import beatrizbonatto.com.model.TipoDispositivo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Schema(description = "Dispositivo de Informatica a ser leiloado")
public class DispInformaticaDTO {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private TipoDispositivo tipoDispositivo;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    public DispInformaticaDTO() {}

    public DispInformaticaDTO(String modelo, String marca, TipoDispositivo tipoDispositivo) {
        this.modelo = modelo;
        this.marca = marca;
        this.tipoDispositivo = tipoDispositivo;
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
