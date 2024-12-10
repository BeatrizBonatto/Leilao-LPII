package beatrizbonatto.com.model;

public class Utilitario extends Veiculo {
    private Integer capacidadePassageiros;

    public Utilitario(Long id, SubTipo subTipo, String nome, String descricao, Double precoInicial, Leilao leilao,
                      String placa, String cor,
                      Integer capacidadePassageiros) {
        super(id, subTipo, nome, descricao, precoInicial, leilao, placa, cor);
        this.capacidadePassageiros = capacidadePassageiros;
    }

    public Integer getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    public void setCapacidadePassageiros(Integer capacidadePassageiros) {
        this.capacidadePassageiros = capacidadePassageiros;
    }

}
