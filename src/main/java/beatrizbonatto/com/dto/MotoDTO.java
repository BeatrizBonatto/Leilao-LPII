package beatrizbonatto.com.dto;

public class MotoDTO extends VeiculoDTO {
    private Integer cilindrada;

    public MotoDTO(String nome, String descricao, Double precoInicial, Long idLeilao, String placa, String cor,
                   Integer cilindrada) {
        super(nome, descricao, precoInicial, idLeilao, placa, cor);
        this.cilindrada = cilindrada;
    }

    public Integer getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }
}
