package beatrizbonatto.com.repository;

import beatrizbonatto.com.model.DispInformatica;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class DispInformaticaRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void registroDispInformatica(DispInformatica dispInformatica) {
        em.persist(dispInformatica);
    }

    public DispInformatica consultaDispInformatica(Long id) {
        return em.find(DispInformatica.class, id);
    }

    @Transactional
    public List<DispInformatica> listaDeDispInformatica() {
        return em.createQuery("select c from DispInformatica c", DispInformatica.class).getResultList();
    }

    @Transactional
    public void atualizar(DispInformatica dispInformatica) {
        em.merge(dispInformatica);
    }

    @Transactional
    public void remocao(Long id) {
        DispInformatica dispInformatica = consultaDispInformatica(id);
        if (dispInformatica != null) {
            em.remove(dispInformatica);
        }
    }
}
