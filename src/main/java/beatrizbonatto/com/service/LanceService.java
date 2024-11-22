package beatrizbonatto.com.service;

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
        em.persist(lanceDTO);
    }

    public Lance buscarLancePorId(Long id) {
        return lanceRepository.buscaLancePorId(id);
    }

    public List<Lance> listaDeLances() {
        return lanceRepository.listaDeLances();
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
