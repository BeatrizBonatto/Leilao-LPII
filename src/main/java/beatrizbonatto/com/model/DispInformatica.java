package beatrizbonatto.com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class DispInformatica extends Produto {
    private String cor;
    private String marca;

    public DispInformatica() {}

    public DispInformatica(Long id, SubTipo subTipo, String nome, String descricao, Double precoInicial, Leilao leilao,
                           String cor, String marca) {
        super(id, subTipo, nome, descricao, precoInicial, leilao);
        this.cor = cor;
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
