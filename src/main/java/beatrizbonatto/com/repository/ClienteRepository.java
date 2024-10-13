package beatrizbonatto.com.repository;

import beatrizbonatto.com.model.Cliente;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ClienteRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void registroCliente(Cliente cliente) {
        em.persist(cliente);
    }

    public Cliente consultaCliente(Long id) {
        return em.find(Cliente.class, id);
    }

    @Transactional
    public List<Cliente> listaDeClientes() {
        return em.createQuery("select c from Cliente c", Cliente.class).getResultList();
    }

    @Transactional
    public void atualizar(Cliente cliente) {
        em.merge(cliente);
    }

    @Transactional
    public void remocao(Long id) {
        Cliente cliente = consultaCliente(id);
        if (cliente != null) {
            em.remove(cliente);
        }
    }
}
