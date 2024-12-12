package beatrizbonatto.com.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CAMINHAO")
public class Caminhao extends Veiculo {
    private Integer quantidadeEixo;

    public Caminhao(Long id, String nome, String descricao, Double precoInicial, Leilao leilao,
                    String placa, String cor, Integer quantidadeEixo) {
        super(id, nome, descricao, precoInicial, leilao, placa, cor);
        this.quantidadeEixo = quantidadeEixo;
    }

    public Caminhao() {}

    public Integer getQuantidadeEixo() {
        return quantidadeEixo;
    }

    public void setQuantidadeEixo(Integer quantidadeEixo) {
        this.quantidadeEixo = quantidadeEixo;
    }
}
