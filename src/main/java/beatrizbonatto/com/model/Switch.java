package beatrizbonatto.com.model;

public class Switch extends DispInformatica {
    private Boolean gerenciavel;

    public Switch(Long id, String nome, String descricao, Double precoInicial, Leilao leilao,
                  String cor, String marca,
                  Boolean gerenciavel) {
        super(id, nome, descricao, precoInicial, leilao, cor, marca);
        this.gerenciavel = gerenciavel;
    }
}
