package beatrizbonatto.com.repository;

import beatrizbonatto.com.dto.ProdutoDTO;
import beatrizbonatto.com.model.Produto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class ProdutoRepository {

    @Inject
    EntityManager em;

    public List<ProdutoDTO> listaDeProdutos() {
        return em.createQuery("select p from Produto p", ProdutoDTO.class).getResultList();
    }

    public ProdutoDTO buscarProdutoPorId(Long id) {
        return em.createQuery("select p from Produto p where p.id = :id", ProdutoDTO.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
