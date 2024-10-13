package beatrizbonatto.com.dto;

import beatrizbonatto.com.model.TipoDispositivo;

public class DispInformaticaDTO {
    private Long id;
    private TipoDispositivo tipoDispositivo;
    private String marca;
    private String modelo;

    public DispInformaticaDTO(TipoDispositivo tipoDispositivo, String modelo, String marca) {}

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
