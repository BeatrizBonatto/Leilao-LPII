package beatrizbonatto.com.repository;

import beatrizbonatto.com.dto.HistoricoLancesDTO;
import beatrizbonatto.com.model.Lance;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class LanceRepository {

    @Inject
    EntityManager em;

    public List<Lance> listaDeLances() {
        return em.createQuery("select la from Lance la", Lance.class).getResultList();
    }

    public  Lance buscaLancePorId(Long id) {
        return em.createQuery("select la from Lance la where la.id = :id", Lance.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public  Lance buscarLancesPorProdutoId(Long id) {
        return em.createQuery("select la from Lance la where la.produto = :id", Lance.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<HistoricoLancesDTO> buscarHistoricoLancesPorProduto(Long produtoId) {
        String query = "SELECT la.id, la.produto.nome, la.cliente.nome, la.valor " +
                       "FROM Lance la " +
                       "WHERE la.produto.id = :produtoId " +
                       "ORDER BY la.id";

        List<Object[]> resultados = em.createQuery(query, Object[].class)
                .setParameter("produtoId", produtoId)
                .getResultList();

        // Converter os resultados manualmente
        List<HistoricoLancesDTO> lancesDTO = new ArrayList<>();
        for (Object[] resultado : resultados) {
            lancesDTO.add(new HistoricoLancesDTO(
                    ((Number) resultado[0]).intValue(),
                    (String) resultado[1],
                    (String) resultado[2],
                    (Double) resultado[3]
            ));
        }

        return lancesDTO;
    }

}
