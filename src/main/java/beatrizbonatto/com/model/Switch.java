package beatrizbonatto.com.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SWITCH")
public class Switch extends DispInformatica {
    private Boolean gerenciavel;

    public Switch(Long id, String nome, String descricao, Double precoInicial, Leilao leilao,
                  String cor, String marca,
                  Boolean gerenciavel) {
        super(id, nome, descricao, precoInicial, leilao, cor, marca);
        this.gerenciavel = gerenciavel;
    }

    public Switch() {
    }

    public Boolean getGerenciavel() {
        return gerenciavel;
    }

    public void setGerenciavel(Boolean gerenciavel) {
        this.gerenciavel = gerenciavel;
    }
}
