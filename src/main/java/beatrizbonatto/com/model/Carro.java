package beatrizbonatto.com.model.Produtos;

import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.model.SubTipo;

public class Carro extends Veiculo {
    private String tipoDeCambio;

    public Carro(Long id, SubTipo subTipo, String nome, String descricao, Double precoInicial, Leilao leilao,
                 String placa, String cor,
                 String tipoDeCambio) {
        super(id, subTipo, nome, descricao, precoInicial, leilao, placa, cor);
        this.tipoDeCambio = tipoDeCambio;
    }

    public String getTipoDeCambio() {
        return tipoDeCambio;
    }

    public void setTipoDeCambio(String tipoDeCambio) {
        this.tipoDeCambio = tipoDeCambio;
    }
}
