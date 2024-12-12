package beatrizbonatto.com.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MOTO")
public class Moto extends Veiculo {
    private Integer cilindrada;

    public Moto(Long id, String nome, String descricao, Double precoInicial, Leilao leilao,
                String placa, String cor, Integer cilindrada) {
        super(id, nome, descricao, precoInicial, leilao, placa, cor);
        this.cilindrada = cilindrada;
    }

    public Moto() {}

    public Integer getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }
}
