package beatrizbonatto.com.dto;

import beatrizbonatto.com.model.Leilao;

public class CarroDTO extends VeiculoDTO {
    private String tipoDeCambio;

    public CarroDTO(String nome, String descricao, Double precoInicial, Long idLeilao, String placa, String cor,
                    String tipoDeCambio) {
        super(nome, descricao, precoInicial, idLeilao, placa, cor);
        this.tipoDeCambio = tipoDeCambio;
    }

    public String getTipoDeCambio() {
        return tipoDeCambio;
    }

    public void setTipoDeCambio(String tipoDeCambio) {
        this.tipoDeCambio = tipoDeCambio;
    }
}
