package beatrizbonatto.com.repository;

import beatrizbonatto.com.model.Produto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

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

    public Produto buscarProdutoPorLeilao(Long leilaoId, Long produtoId) {
        String query = "SELECT p FROM Produto p " +
                "WHERE p.id = :produtoId " +
                "AND p.leilao.id = :leilaoId";

        return em.createQuery(query, Produto.class)
                .setParameter("leilaoId", leilaoId)
                .setParameter("produtoId", produtoId)
                .getSingleResult();
    }

    @Transactional
    public void salvar(Produto produto) {
        em.merge(produto);
    }

}
