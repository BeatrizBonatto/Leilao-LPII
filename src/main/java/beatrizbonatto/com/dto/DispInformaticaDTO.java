package beatrizbonatto.com.dto;

public class DispInformaticaDTO extends ProdutoDTO {
    private String cor;
    private String marca;

    public DispInformaticaDTO() {}

    public DispInformaticaDTO(String nome, String descricao, Double precoInicial, Long idLeilao, String marca, String cor) {
        super(nome, descricao, precoInicial, idLeilao);
        this.marca = marca;
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
