package beatrizbonatto.com.service;

import beatrizbonatto.com.dto.VeiculoDTO;
import beatrizbonatto.com.model.Veiculo;
import beatrizbonatto.com.repository.VeiculoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class VeiculoService {
    @Inject
    VeiculoRepository veiculoRepository;

    public void createVeiculo(VeiculoDTO veiculoDTO) {
        Veiculo veiculo = new Veiculo();
        veiculo.setTipoVeiculo(veiculoDTO.getTipoVeiculo());
        veiculo.setMarca(veiculoDTO.getMarca());
        veiculo.setModelo(veiculoDTO.getModelo());
        veiculo.setAno(veiculoDTO.getAno());
        veiculo.setCor(veiculoDTO.getCor());
        veiculo.setPlaca(veiculoDTO.getPlaca());
        veiculoRepository.registroVeiculo(veiculo);
    }

    public VeiculoDTO getVeiculo(Long id) {
        Veiculo veiculo = veiculoRepository.consultaVeiculo(id);
        if (veiculo != null) {
            return toDTO(veiculo);
        }
        return null;
    }

    public List<VeiculoDTO> listVeiculos() {
        return veiculoRepository.listaDeVeiculos().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public VeiculoDTO updateVeiculo(Long id, VeiculoDTO veiculoDTO) {
        Veiculo veiculo = veiculoRepository.consultaVeiculo(id);
        if (veiculo != null) {
            veiculo.setTipoVeiculo(veiculoDTO.getTipoVeiculo());
            veiculo.setMarca(veiculoDTO.getMarca());
            veiculo.setModelo(veiculoDTO.getModelo());
            veiculo.setAno(veiculoDTO.getAno());
            veiculo.setCor(veiculoDTO.getCor());
            veiculo.setPlaca(veiculoDTO.getPlaca());
            veiculoRepository.atualizar(veiculo);
            return toDTO(veiculo);
        }
        return null;
    }

    public boolean deleteVeiculo(Long id) {
        Veiculo veiculo = veiculoRepository.consultaVeiculo(id);
        if (veiculo != null) {
            veiculoRepository.remocao(id);
            return true;
        }
        return false;
    }

    private VeiculoDTO toDTO(Veiculo veiculo) {
        return new VeiculoDTO(veiculo.getTipoVeiculo(), veiculo.getMarca(), veiculo.getModelo(), veiculo.getAno(), veiculo.getCor(), veiculo.getPlaca());
    }
}
