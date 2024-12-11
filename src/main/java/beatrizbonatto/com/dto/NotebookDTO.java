package beatrizbonatto.com.dto;


import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.model.SubTipo;

public class NotebookDTO extends ProdutoDTO {
    private String polegada;

    public NotebookDTO() {}

    public NotebookDTO(Long id, SubTipo subTipo, String nome, String descricao, Double precoInicial, Long idLeilao, String polegada) {
        super(id, subTipo, nome, descricao, precoInicial, idLeilao);
        this.polegada = polegada;
    }

    public String getPolegada() {
        return polegada;
    }

    public void setPolegada(String polegada) {
        this.polegada = polegada;
    }

}
