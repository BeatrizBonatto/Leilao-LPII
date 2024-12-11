package beatrizbonatto.com.model.Produtos;

import beatrizbonatto.com.model.DispInformatica;
import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.model.SubTipo;

public class Roteador extends DispInformatica {
    private String velocidadeWiFi;

    public Roteador(Long id, SubTipo subTipo, String nome, String descricao, Double precoInicial, Leilao leilao,
                    String cor, String marca,
                    String velocidadeWiFi) {
        super(id, subTipo, nome, descricao, precoInicial, leilao, cor, marca);
        this.velocidadeWiFi = velocidadeWiFi;
    }

    public String getVelocidadeWiFi() {
        return velocidadeWiFi;
    }

    public void setVelocidadeWiFi(String velocidadeWiFi) {
        this.velocidadeWiFi = velocidadeWiFi;
    }
}
