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
    public void registroInstFinanceira(InstFinanceira instFinanceira) {
        em.persist(instFinanceira);
    }

    public InstFinanceira consultaInstFinanceira(Long id) {
        return em.find(InstFinanceira.class, id);
    }

    @Transactional
    public List<InstFinanceira> listaDeInstFinanceira() {
        return em.createQuery("select if from InstFinanceira if", InstFinanceira.class).getResultList();
    }

    @Transactional
    public void atualizar(InstFinanceira instFinanceira) {
        em.merge(instFinanceira);
    }

    @Transactional
    public void remocao(Long id) {
        InstFinanceira instFinanceira = consultaInstFinanceira(id);
        if (instFinanceira != null) {
            em.remove(instFinanceira);
        }
    }
}
