package beatrizbonatto.com.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ROTEADOR")
public class Roteador extends DispInformatica {
    private String velocidadeWiFi;

    public Roteador(Long id, String nome, String descricao, Double precoInicial, Leilao leilao,
                    String cor, String marca,
                    String velocidadeWiFi) {
        super(id, nome, descricao, precoInicial, leilao, cor, marca);
        this.velocidadeWiFi = velocidadeWiFi;
    }

    public Roteador() {
    }

    public String getVelocidadeWiFi() {
        return velocidadeWiFi;
    }

    public void setVelocidadeWiFi(String velocidadeWiFi) {
        this.velocidadeWiFi = velocidadeWiFi;
    }
}
