package beatrizbonatto.com.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Tipos de dispositivos de informatica disponiveis para leilao")
public enum TipoDispositivo {
    
    NOTEBOOK("Notebook"),
    MONITOR("Monitor"),
    HUB("Hub"),
    SWITCH("Switch"), 
    ROTEADOR("Roteador");

    private String dispositivo;

    TipoDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getVeiculo() {
        return dispositivo;
    }
}
