package beatrizbonatto.com.dto;

public class SwitchDTO extends DispInformaticaDTO {
    private Boolean gerenciavel;

    public SwitchDTO(String nome, String descricao, Double precoInicial, Long idLeilao, String marca, String cor, Boolean gerenciavel) {
        super(nome, descricao, precoInicial, idLeilao, marca, cor);
        this.gerenciavel = gerenciavel;
    }

    public Boolean getGerenciavel() {
        return gerenciavel;
    }

    public void setGerenciavel(Boolean gerenciavel) {
        this.gerenciavel = gerenciavel;
    }
}
