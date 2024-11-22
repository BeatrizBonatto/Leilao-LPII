package beatrizbonatto.com.repository;

import beatrizbonatto.com.dto.LeilaoDTO;
import beatrizbonatto.com.model.Leilao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class LeilaoRepository {

    @Inject
    EntityManager em;

    public List<Leilao> listaDeLeiloes() {
        return em.createQuery("select l from Leilao l", Leilao.class).getResultList();
    }

    public Leilao buscaLeilaoPorId(Long id) {
        return em.createQuery("select l from Leilao l where l.id = :id", Leilao.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
