package beatrizbonatto.com.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("UTILITARIO")
public class Utilitario extends Veiculo {
    private Integer capacidadePassageiros;

    public Utilitario(Long id, String nome, String descricao, Double precoInicial, Leilao leilao,
                      String placa, String cor,
                      Integer capacidadePassageiros) {
        super(id, nome, descricao, precoInicial, leilao, placa, cor);
        this.capacidadePassageiros = capacidadePassageiros;
    }

    public Utilitario() {}

    public Integer getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    public void setCapacidadePassageiros(Integer capacidadePassageiros) {
        this.capacidadePassageiros = capacidadePassageiros;
    }

}
