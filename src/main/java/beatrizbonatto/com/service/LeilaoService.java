package beatrizbonatto.com.service;

import beatrizbonatto.com.dto.LeilaoDTO;
import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.repository.LeilaoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class LeilaoService {
    @Inject
    LeilaoRepository leilaoRepository;

    public void createLeilao(LeilaoDTO leilaoDTO) {
        Leilao leilao = new Leilao();
        leilao.setDataInicio(leilaoDTO.getDataInicio());
        leilao.setDataFim(leilaoDTO.getDataFim());
        leilao.setDataVisitacao(leilaoDTO.getDataVisitacao());
        leilao.setDataEvento(leilaoDTO.getDataEvento());
        leilao.setDominioLeilaoEletronico(leilao.getDominioLeilaoEletronico());
        leilao.setEndereco(leilaoDTO.getEndereco());
        leilao.setCidade(leilaoDTO.getCidade());
        leilao.setEstado(leilaoDTO.getEstado());
        leilao.setStatus(leilaoDTO.getStatus());
        leilaoRepository.registroLeilao(leilao);
    }

    public LeilaoDTO getLeilao(Long id) {
        Leilao leilao = leilaoRepository.consultaLeilao(id);
        if (leilao != null) {
            return toDTO(leilao);
        }
        return null;
    }

    public List<LeilaoDTO> listLeiloes() {
        return leilaoRepository.listaDeLeiloes().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public LeilaoDTO updateLeilao(Long id, LeilaoDTO leilaoDTO) {
        Leilao leilao = leilaoRepository.consultaLeilao(id);
        if (leilao != null) {
            leilao.setDataInicio(leilaoDTO.getDataInicio());
            leilao.setDataFim(leilaoDTO.getDataFim());
            leilao.setDataVisitacao(leilaoDTO.getDataVisitacao());
            leilao.setDataEvento(leilaoDTO.getDataEvento());
            leilao.setDominioLeilaoEletronico(leilao.getDominioLeilaoEletronico());
            leilao.setEndereco(leilaoDTO.getEndereco());
            leilao.setCidade(leilaoDTO.getCidade());
            leilao.setEstado(leilaoDTO.getEstado());
            leilao.setStatus(leilaoDTO.getStatus());
            leilaoRepository.atualizar(leilao);
            return toDTO(leilao);
        }
        return null;
    }

    public boolean deleteLeilao(Long id) {
        Leilao leilao = leilaoRepository.consultaLeilao(id);
        if (leilao != null) {
            leilaoRepository.remocao(id);
            return true;
        }
        return false;
    }

    private LeilaoDTO toDTO(Leilao leilao) {
        return new LeilaoDTO(leilao.getDataInicio(), leilao.getDataFim(), leilao.getDataVisitacao(), leilao.getDataEvento(),leilao.getDominioLeilaoEletronico(), leilao.getEndereco(), leilao.getCidade(), leilao.getEstado(), leilao.getStatus());
    }
}
