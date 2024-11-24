package beatrizbonatto.com.repository;

import beatrizbonatto.com.dto.DetalhesLeilaoDTO;
import beatrizbonatto.com.dto.LeilaoDTO;
import beatrizbonatto.com.model.Leilao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class LeilaoRepository {

    @Inject
    EntityManager em;

    public List<Leilao> listaDeLeiloes() {
        return em.createQuery("select l from Leilao l", Leilao.class).getResultList();
    }

    public Leilao buscaLeilaoPorId(Long id) {
        return em.createQuery("select l from Leilao l where l.id = :id", Leilao.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<Leilao> listaDeLeiloesOrdenadoPorDataEvento() {
        return em.createQuery("select l from Leilao l order by l.dataInicio", Leilao.class).getResultList();
    }

    public DetalhesLeilaoDTO detalhesDoLeilaoPorId(Long leilaoId) {
        String query = "SELECT l.id, l.dataInicio, l.dataFim, l.dataVisita, " +
                "l.dominioLeilaoEletronico, l.endereco, l.cidade, l.estado, " +
                "COUNT(p.id), i.nome " +
                "FROM Leilao l " +
                "LEFT JOIN l.instFinanceira i " +
                "LEFT JOIN l.produtos p " +
                "WHERE l.id = :leilaoId " +
                "GROUP BY l.id, l.dataInicio, l.dataFim, l.dataVisita, l.dominioLeilaoEletronico, " +
                "l.endereco, l.cidade, l.estado, i.nome " +
                "ORDER BY p.subTipo";

        return em.createQuery(query, DetalhesLeilaoDTO.class)
                .setParameter("leilaoId", leilaoId)
                .getSingleResult();
    }


}
