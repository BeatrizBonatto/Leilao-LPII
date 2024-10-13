package beatrizbonatto.com.repository;

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

    @Transactional
    public void registroLeilao(Leilao leilao) {
        em.persist(leilao);
    }

    public Leilao consultaLeilao(Long id) {
        return em.find(Leilao.class, id);
    }

    @Transactional
    public List<Leilao> listaDeLeiloes() {
        return em.createQuery("select l from Leilao l", Leilao.class).getResultList();
    }

    @Transactional
    public void atualizar(Leilao leilao) {
        em.merge(leilao);
    }

    @Transactional
    public void remocao(Long id) {
        Leilao leilao = consultaLeilao(id);
        if (leilao != null) {
            em.remove(leilao);
        }
    }
}
