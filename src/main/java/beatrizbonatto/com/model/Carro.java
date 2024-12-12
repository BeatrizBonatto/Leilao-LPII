package beatrizbonatto.com.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CARRO")
public class Carro extends Veiculo {
    private String tipoDeCambio;

    public Carro(Long id, String nome, String descricao, Double precoInicial, Leilao leilao,
                 String placa, String cor,
                 String tipoDeCambio) {
        super(id, nome, descricao, precoInicial, leilao, placa, cor);
        this.tipoDeCambio = tipoDeCambio;
    }

    public Carro() {}

    public String getTipoDeCambio() {
        return tipoDeCambio;
    }

    public void setTipoDeCambio(String tipoDeCambio) {
        this.tipoDeCambio = tipoDeCambio;
    }
}
