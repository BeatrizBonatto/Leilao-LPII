package beatrizbonatto.com.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "tipo de produto")
public enum Tipo {

    VEICULO("Veículo"),
    DISPOSITIVO_INFORMATICA("Dispositívo de Informática");

    private String tipo;

    Tipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
