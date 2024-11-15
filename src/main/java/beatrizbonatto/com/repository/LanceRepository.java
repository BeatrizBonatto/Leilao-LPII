package beatrizbonatto.com.repository;

import beatrizbonatto.com.dto.LanceDTO;
import beatrizbonatto.com.model.Lance;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class LanceRepository {

    @Inject
    EntityManager em;

    public List<LanceDTO> listaDeLances() {
        return em.createQuery("select la from Lance la", LanceDTO.class).getResultList();
    }

    public  LanceDTO buscaLancePorId(Long id) {
        return em.createQuery("select la from Lance la where la.id = :id", LanceDTO.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
