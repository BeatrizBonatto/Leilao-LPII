package beatrizbonatto.com.repository;

import beatrizbonatto.com.model.Produto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class ProdutoRepository {

    @Inject
    EntityManager em;

    public List<Produto> listaDeProdutos() {
        return em.createQuery("select p from Produto p", Produto.class).getResultList();
    }

    public Produto buscarProdutoPorId(Long id) {
        return em.createQuery("select p from Produto p where p.id = :id", Produto.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
