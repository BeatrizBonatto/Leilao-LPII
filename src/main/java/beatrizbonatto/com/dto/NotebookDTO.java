package beatrizbonatto.com.dto;

public class NotebookDTO extends DispInformaticaDTO {
    private String polegada;

    public NotebookDTO() {}

    public NotebookDTO(String nome, String descricao, Double precoInicial, Long idLeilao, String marca, String cor, String polegada) {
        super(nome, descricao, precoInicial, idLeilao, marca, cor);
        this.polegada = polegada;
    }

    public String getPolegada() {
        return polegada;
    }

    public void setPolegada(String polegada) {
        this.polegada = polegada;
    }

}
