package beatrizbonatto.com.model.Produtos;

import beatrizbonatto.com.model.DispInformatica;
import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.model.SubTipo;

public class Switch extends DispInformatica {
    private Boolean gerenciavel;

    public Switch(Long id, SubTipo subTipo, String nome, String descricao, Double precoInicial, Leilao leilao,
                  String cor, String marca,
                  Boolean gerenciavel) {
        super(id, subTipo, nome, descricao, precoInicial, leilao, cor, marca);
        this.gerenciavel = gerenciavel;
    }
}
