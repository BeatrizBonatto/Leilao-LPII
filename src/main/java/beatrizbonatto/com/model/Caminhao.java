package beatrizbonatto.com.model;

public class Caminhao extends Veiculo {
    private Integer quantidadeEixo;

    public Caminhao(Long id, SubTipo subTipo, String nome, String descricao, Double precoInicial, Leilao leilao,
                    String placa, String cor,
                    Integer quantidadeEixo) {
        super(id, subTipo, nome, descricao, precoInicial, leilao, placa, cor);
        this.quantidadeEixo = quantidadeEixo;
    }

    public Integer getQuantidadeEixo() {
        return quantidadeEixo;
    }

    public void setQuantidadeEixo(Integer quantidadeEixo) {
        this.quantidadeEixo = quantidadeEixo;
    }
}
