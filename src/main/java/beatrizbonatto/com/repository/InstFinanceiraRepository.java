package beatrizbonatto.com.repository;

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
    public List<InstFinanceira> listaDeInstFinanceira() {
        return em.createQuery("select if from InstFinanceira if", InstFinanceira.class)
                .getResultList();
    }

    @Transactional
    public InstFinanceira buscarInstFinanceiraPorId(Long id) {
        return em.createQuery("select if from InstFinanceira if where id = :id", InstFinanceira.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
