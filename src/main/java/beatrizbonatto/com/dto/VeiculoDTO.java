package beatrizbonatto.com.dto;

public class VeiculoDTO extends ProdutoDTO {
    private String placa;
    private String cor;

    public VeiculoDTO() {}

    public VeiculoDTO(String nome, String descricao, Double precoInicial, Long idLeilao, String placa, String cor) {
        super(nome, descricao, precoInicial, idLeilao);
        this.placa = placa;
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

}
