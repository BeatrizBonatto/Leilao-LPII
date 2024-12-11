package beatrizbonatto.com.service;

import beatrizbonatto.com.dto.InstFinanceiraDTO;
import beatrizbonatto.com.model.InstFinanceira;
import beatrizbonatto.com.repository.InstFinanceiraRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class InstFinanceiraService {
    @Inject
    InstFinanceiraRepository instFinanceiraRepository;

    @Inject
    EntityManager em;

    @Transactional
    public void criarInstFinanceira(InstFinanceiraDTO instFinanceiraDTO) {
        em.persist(instFinanceiraDTO);
    }

    public InstFinanceira buscarInstFinanceira(Long id) {
        return instFinanceiraRepository.buscarInstFinanceiraPorId(id);
    }

    @Transactional
    public List<InstFinanceira> listaDeInstFinanceira() {
        return instFinanceiraRepository.listaDeInstFinanceira();
    }

    @Transactional
    public InstFinanceiraDTO atualizarInstFinanceira(Long id, InstFinanceiraDTO instFinanceiraAtualizada) {
        if(buscarInstFinanceira(id) != null) {
            em.merge(instFinanceiraAtualizada);
            return instFinanceiraAtualizada;
        }
        throw new IllegalArgumentException("Instituição Financeira não existe");
    }

    @Transactional
    public boolean excluirInstFinanceira(Long id) {
        if(em.find(InstFinanceiraDTO.class, id) != null) {
            InstFinanceira instFinanceira = buscarInstFinanceira(id);
            em.remove(instFinanceira);
            return true;
        }
        throw new IllegalArgumentException("Instituição Financeira não existe");
    }

    private InstFinanceiraDTO toDTO(InstFinanceira instFinanceira) {
        return new InstFinanceiraDTO(
                instFinanceira.getCodigo(),
                instFinanceira.getNome(),
                instFinanceira.getCnpj(),
                instFinanceira.getLeiloes()
        );
    }
}
