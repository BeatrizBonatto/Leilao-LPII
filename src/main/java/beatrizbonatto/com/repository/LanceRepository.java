package beatrizbonatto.com.repository;

import beatrizbonatto.com.model.Lance;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class LanceRepository {

    @Inject
    EntityManager em;

    public List<Lance> listaDeLances() {
        return em.createQuery("select la from Lance la", Lance.class).getResultList();
    }

    public  Lance buscaLancePorId(Long id) {
        return em.createQuery("select la from Lance la where la.id = :id", Lance.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public  Lance buscarLancesPorProdutoId(Long id) {
        return em.createQuery("select la from Lance la where la.produto = :id", Lance.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
