package beatrizbonatto.com.dto;

public class UtilitarioDTO extends VeiculoDTO {
    private Integer capacidadePassageiros;

    public UtilitarioDTO(String nome, String descricao, Double precoInicial, Long idLeilao, String placa, String cor,
                         Integer capacidadePassageiros) {
        super(nome, descricao, precoInicial, idLeilao, placa, cor);
        this.capacidadePassageiros = capacidadePassageiros;
    }

    public Integer getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    public void setCapacidadePassageiros(Integer capacidadePassageiros) {
        this.capacidadePassageiros = capacidadePassageiros;
    }

}
