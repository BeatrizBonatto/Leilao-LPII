package beatrizbonatto.com.service;

import beatrizbonatto.com.dto.LanceDTO;
import beatrizbonatto.com.model.Lance;
import beatrizbonatto.com.model.Produto;
import beatrizbonatto.com.repository.LanceRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class LanceService {
    @Inject
    LanceRepository lanceRepository;

    public void createLance(LanceDTO lanceDTO) {
        for (Produto produto : lanceDTO.getProdutos()) {
            Lance lanceAtual = lanceRepository.listaDeLances().stream()
                    .filter(l -> l.getProdutos().contains(produto))
                    .findFirst()
                    .orElse(null);

            if (lanceAtual != null && lanceAtual.getValor() >= lanceDTO.getValor()) {
                throw new IllegalArgumentException("O lance deve ser maior que o lance atual do produto " + produto.getTipo());
            }
        }

        Lance lance = new Lance();
        lance.setClientes(lanceDTO.getClientes());
        lance.setProdutos(lanceDTO.getProdutos());
        lance.setValor(lanceDTO.getValor());
        lanceRepository.registroLance(lance);
    }

    public LanceDTO getLance(Long id) {
        Lance lance = lanceRepository.consultaLance(id);
        if (lance != null) {
            return toDTO(lance);
        }
        return null;
    }

    public List<LanceDTO> listLances() {
        return lanceRepository.listaDeLances().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public LanceDTO updateLance(Long id, LanceDTO lanceDTO) {
        Lance lance = lanceRepository.consultaLance(id);
        if (lance != null) {
            lance.setClientes(lanceDTO.getClientes());
            lance.setProdutos(lanceDTO.getProdutos());
            lance.setValor(lanceDTO.getValor());
            return toDTO(lance);
        }
        return null;
    }

    public boolean deleteLance(Long id) {
        Lance lance = lanceRepository.consultaLance(id);
        if (lance != null) {
            lanceRepository.remocao(id);
            return true;
        }
        return false;
    }

    private LanceDTO toDTO(Lance lance) {
        return new LanceDTO(lance.getClientes(), lance.getProdutos(), lance.getValor());
    }
}
