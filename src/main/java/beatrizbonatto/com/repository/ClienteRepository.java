package beatrizbonatto.com.repository;

import beatrizbonatto.com.dto.ClienteDTO;
import beatrizbonatto.com.model.Cliente;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class ClienteRepository {

    @Inject
    EntityManager em;

    public List<Cliente> listaDeClientes() {
        return em.createQuery("select c from Cliente c", Cliente.class).getResultList();
    }

    public Cliente ClientePorId(Long id) {
        return em.createQuery("select c from Cliente c where c.id = :id", Cliente.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
