package beatrizbonatto.com.service;

import beatrizbonatto.com.dto.HistoricoLancesDTO;
import beatrizbonatto.com.dto.LanceDTO;
import beatrizbonatto.com.model.Lance;
import beatrizbonatto.com.repository.LanceRepository;
import beatrizbonatto.com.repository.LeilaoRepository;
import beatrizbonatto.com.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class LanceService {
    @Inject
    LanceRepository lanceRepository;

    @Inject
    ProdutoRepository produtoRepository;

    @Inject
    LeilaoRepository leilaoRepository;

    @Inject
    EntityManager em;

    @Transactional
    public void criarLance(LanceDTO lanceDTO) {
        if (lanceDTO.getProduto() != null && lanceDTO.getCliente() != null && lanceDTO.getValor() != null) {
            if (lanceDTO.getValor() > lanceDTO.getProduto().getPrecoInicial()) {

                Lance lance = new Lance();
                lance.setProduto(lanceDTO.getProduto());
                lance.setCliente(lanceDTO.getCliente());
                lance.setValor(lanceDTO.getValor());

                em.persist(lance);
            } else {
                throw new IllegalArgumentException("Valor do lance precisa ser maior que o valor inicial do produto");
            }
        } else {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }
    }

    public Lance buscarLancePorId(Long id) {
        return lanceRepository.buscaLancePorId(id);
    }

    public List<Lance> listaDeLances() {
        return lanceRepository.listaDeLances();
    }

    public List<HistoricoLancesDTO> buscarHistoricoLancesPorProduto(Long produtoId) {
        return lanceRepository.buscarHistoricoLancesPorProduto(produtoId);
    }

    @Transactional
    public LanceDTO atualizarLance(Long id, LanceDTO lanceAtualizado) {
        if(buscarLancePorId(id) != null) {
            em.merge(lanceAtualizado);
            return lanceAtualizado;
        }
        throw new IllegalArgumentException("Lance não existe");
    }

    @Transactional
    public boolean excluirLance(Long id) {
        if(buscarLancePorId(id) != null) {
            em.remove(id);
            return true;
        }
        throw new IllegalArgumentException("Lance não existe");
    }

    private LanceDTO toDTO(Lance lance) {
        return new LanceDTO(lance.getId() , lance.getCliente(), lance.getProduto(), lance.getValor());
    }
}
