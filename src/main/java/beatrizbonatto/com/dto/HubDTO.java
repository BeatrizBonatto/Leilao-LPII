package beatrizbonatto.com.dto;

import beatrizbonatto.com.model.Leilao;

public class HubDTO extends DispInformaticaDTO {
    private Integer quantidadePortas;

    public HubDTO(String nome, String descricao, Double precoInicial, Long idLeilao, String marca, String cor, Integer quantidadePortas) {
        super(nome, descricao, precoInicial, idLeilao, marca, cor);
        this.quantidadePortas = quantidadePortas;
    }

    public Integer getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(Integer quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }
}
