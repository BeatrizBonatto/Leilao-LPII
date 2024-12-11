package beatrizbonatto.com.model.Produtos;

import beatrizbonatto.com.model.DispInformatica;
import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.model.SubTipo;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("NOTEBOOK")
public class Notebook extends DispInformatica {
    private String polegada;

    public Notebook() {}

    public Notebook(Long id, SubTipo subTipo, String nome, String descricao, Double precoInicial, Leilao leilao,
                    String cor, String marca,
                    String polegada) {
        super(id, subTipo, nome, descricao, precoInicial, leilao, cor, marca);
        this.polegada = polegada;
    }

    public String getPolegada() {
        return polegada;
    }

    public void setPolegada(String polegada) {
        this.polegada = polegada;
    }
}
