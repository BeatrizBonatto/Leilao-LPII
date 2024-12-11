package beatrizbonatto.com.model.Produtos;

import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.model.Produto;
import beatrizbonatto.com.model.SubTipo;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Veiculo extends Produto {
    private String placa;
    private String cor;

    public Veiculo() {}

    public Veiculo(Long id, SubTipo subTipo, String nome, String descricao, Double precoInicial, Leilao leilao,
                   String placa, String cor) {
        super(id, subTipo, nome, descricao, precoInicial, leilao);
        this.placa = placa;
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

}
