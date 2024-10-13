package beatrizbonatto.com.repository;

import beatrizbonatto.com.model.Lance;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class LanceRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void registroLance(Lance lance) {
        em.persist(lance);
    }

    public Lance consultaLance(Long id) {
        return em.find(Lance.class, id);
    }

    @Transactional
    public List<Lance> listaDeLances() {
        return em.createQuery("select la from Lance la", Lance.class).getResultList();
    }

    @Transactional
    public void atualizar(Lance lance) {
        em.merge(lance);
    }

    @Transactional
    public void remocao(Long id) {
        Lance lance = consultaLance(id);
        if (lance != null) {
            em.remove(lance);
        }
    }
}
