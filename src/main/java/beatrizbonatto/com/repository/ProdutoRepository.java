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

    @Transactional
    public void registroProduto(Produto produto) {
        em.persist(produto);
    }

    public Produto consultaProduto(Long id) {
        return em.find(Produto.class, id);
    }

    @Transactional
    public List<Produto> listaDeProdutos() {
        return em.createQuery("select p from Produto p", Produto.class).getResultList();
    }

    @Transactional
    public void atualizar(Produto produto) {
        em.merge(produto);
    }

    @Transactional
    public void remocao(Long id) {
        Produto produto = consultaProduto(id);
        if (produto != null) {
            em.remove(produto);
        }
    }
}
