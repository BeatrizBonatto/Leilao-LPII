package beatrizbonatto.com.dto;

import beatrizbonatto.com.model.DispInformatica;
import beatrizbonatto.com.model.Leilao;

public class RoteadorDTO extends DispInformaticaDTO {
    private String velocidadeWiFi;

    public RoteadorDTO(String nome, String descricao, Double precoInicial, Long idLeilao, String marca, String cor, String velocidadeWiFi) {
        super(nome, descricao, precoInicial, idLeilao, marca, cor);
        this.velocidadeWiFi = velocidadeWiFi;
    }

    public String getVelocidadeWiFi() {
        return velocidadeWiFi;
    }

    public void setVelocidadeWiFi(String velocidadeWiFi) {
        this.velocidadeWiFi = velocidadeWiFi;
    }
}
