package beatrizbonatto.com.repository;

import beatrizbonatto.com.dto.ClienteDTO;
import beatrizbonatto.com.dto.InstFinanceiraDTO;
import beatrizbonatto.com.model.InstFinanceira;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class InstFinanceiraRepository {

    @Inject
    EntityManager em;

    @Transactional
    public List<InstFinanceiraDTO> listaDeInstFinanceira() {
        return em.createQuery("select if from InstFinanceira if", InstFinanceiraDTO.class)
                .getResultList();
    }

    @Transactional
    public InstFinanceiraDTO buscarInstFinanceiraPorId(Long id) {
        return em.createQuery("select if from InstFinanceira if where id = :id", InstFinanceiraDTO.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
