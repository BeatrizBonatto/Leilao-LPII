package beatrizbonatto.com.dto;

public class NotebookDTO extends ProdutoDTO {
    private String polegada;

    public NotebookDTO() {}

    public NotebookDTO(String nome, String descricao, Double precoInicial, Long idLeilao, String polegada) {
        super(nome, descricao, precoInicial, idLeilao);
        this.polegada = polegada;
    }

    public String getPolegada() {
        return polegada;
    }

    public void setPolegada(String polegada) {
        this.polegada = polegada;
    }

}
