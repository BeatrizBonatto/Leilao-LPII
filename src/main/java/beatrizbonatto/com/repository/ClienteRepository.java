package beatrizbonatto.com.repository;

import beatrizbonatto.com.dto.ClienteDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class ClienteRepository {

    @Inject
    EntityManager em;

    public List<ClienteDTO> listaDeClientes() {
        return em.createQuery("select c from Cliente c", ClienteDTO.class).getResultList();
    }

    public ClienteDTO ClientePorId(Long id) {
        return em.createQuery("select c from Cliente c where c.id = :id", ClienteDTO.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
