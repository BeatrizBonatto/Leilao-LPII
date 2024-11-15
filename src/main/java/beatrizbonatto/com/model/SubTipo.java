package beatrizbonatto.com.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "subtipo de produto")
public enum SubTipo {

    CARRO(Tipo.VEICULO, "Carro de passeio"),
    MOTO(Tipo.VEICULO, "Moto de passeio"),
    CAMINHAO(Tipo.VEICULO, "Caminhão"),
    UTILITARIO(Tipo.VEICULO, "Utilitário"),
    NOTEBOOK(Tipo.DISPOSITIVO_INFORMATICA, "Notebook"),
    MONITOR(Tipo.DISPOSITIVO_INFORMATICA, "Monitor"),
    HUB(Tipo.DISPOSITIVO_INFORMATICA, "Hub"),
    SWITCH(Tipo.DISPOSITIVO_INFORMATICA, "Switch"),
    ROTEADOR(Tipo.DISPOSITIVO_INFORMATICA, "Roteador");

    Tipo tipo;
    String subTipo;

    SubTipo(Tipo tipo, String subTipo) {
        this.tipo = tipo;
        this.subTipo = subTipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getSubTipo() {
        return subTipo;
    }

}
