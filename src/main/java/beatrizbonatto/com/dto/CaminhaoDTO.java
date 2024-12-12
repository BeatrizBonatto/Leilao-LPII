package beatrizbonatto.com.dto;

public class CaminhaoDTO extends VeiculoDTO {
    private Integer quantidadeEixo;

    public CaminhaoDTO(String nome, String descricao, Double precoInicial, Long idLeilao, String placa, String cor,
                       Integer quantidadeEixo) {
        super(nome, descricao, precoInicial, idLeilao, placa, cor);
        this.quantidadeEixo = quantidadeEixo;
    }

    public CaminhaoDTO() {}

    public Integer getQuantidadeEixo() {
        return quantidadeEixo;
    }

    public void setQuantidadeEixo(Integer quantidadeEixo) {
        this.quantidadeEixo = quantidadeEixo;
    }
}
