package beatrizbonatto.com.repository;

import beatrizbonatto.com.model.Veiculo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class VeiculoRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void registroVeiculo(Veiculo veiculo) {
        em.persist(veiculo);
    }

    public Veiculo consultaVeiculo(Long id) {
        return em.find(Veiculo.class, id);
    }

    @Transactional
    public List<Veiculo> listaDeVeiculos() {
        return em.createQuery("select v from Veiculo v", Veiculo.class).getResultList();
    }

    @Transactional
    public void atualizar(Veiculo veiculo) {
        em.merge(veiculo);
    }

    @Transactional
    public void remocao(Long id) {
        Veiculo veiculo = consultaVeiculo(id);
        if (veiculo != null) {
            em.remove(veiculo);
        }
    }
}
