package beatrizbonatto.com.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Tipos de veiculos disponiveis para leilao")
public enum TipoVeiculo {

    CARRO("Carro de passeio"),
    MOTO("Moto de passeio"),
    CAMINHAO("Caminhão"),
    UTILITARIO("Utilitário");

    private String veiculo;

    TipoVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getVeiculo() {
        return veiculo;
    }
}
