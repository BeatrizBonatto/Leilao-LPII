package beatrizbonatto.com.model.Produtos;


import beatrizbonatto.com.model.DispInformatica;
import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.model.SubTipo;

public class Hub extends DispInformatica {
    private Integer quantidadePortas;

    public Hub(Long id, SubTipo subTipo, String nome, String descricao, Double precoInicial, Leilao leilao,
               String cor, String marca,
               Integer quantidadePortas) {
        super(id, subTipo, nome, descricao, precoInicial, leilao, cor, marca);
        this.quantidadePortas = quantidadePortas;
    }

    public Integer getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(Integer quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }
}
