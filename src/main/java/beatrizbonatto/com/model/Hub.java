package beatrizbonatto.com.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("HUB")
public class Hub extends DispInformatica {
    private Integer quantidadePortas;

    public Hub(Long id, String nome, String descricao, Double precoInicial, Leilao leilao,
               String cor, String marca,
               Integer quantidadePortas) {
        super(id, nome, descricao, precoInicial, leilao, cor, marca);
        this.quantidadePortas = quantidadePortas;
    }

    public Hub() {

    }

    public Integer getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(Integer quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }
}
