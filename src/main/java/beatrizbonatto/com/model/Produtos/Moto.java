package beatrizbonatto.com.model.Produtos;

import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.model.SubTipo;

public class Moto extends Veiculo {
    private Integer cilindrada;

    public Moto(Long id, SubTipo subTipo, String nome, String descricao, Double precoInicial, Leilao leilao,
                String placa, String cor,
                Integer cilindrada) {
        super(id, subTipo, nome, descricao, precoInicial, leilao, placa, cor);
        this.cilindrada = cilindrada;
    }

    public Integer getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }
}
