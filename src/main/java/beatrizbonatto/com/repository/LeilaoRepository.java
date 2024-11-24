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
        // Consulta o Leilão e extrai os dados necessários
        String leilaoQuery = "SELECT l FROM Leilao l WHERE l.id = :leilaoId";
        Leilao leilao = em.createQuery(leilaoQuery, Leilao.class)
                .setParameter("leilaoId", leilaoId)
                .getSingleResult();

        // Consulta os nomes dos produtos associados ao leilão
        String produtosQuery = "SELECT p.nome FROM Produto p WHERE p.leilao.id = :leilaoId";
        List<String> produtos = em.createQuery(produtosQuery, String.class)
                .setParameter("leilaoId", leilaoId)
                .getResultList();

        // Consulta os nomes das instituições financeiras associadas ao leilão
        String instFinanceirasQuery = "SELECT i.nome FROM InstFinanceira i JOIN i.leiloes l WHERE l.id = :leilaoId";
        List<String> instFinanceiras = em.createQuery(instFinanceirasQuery, String.class)
                .setParameter("leilaoId", leilaoId)
                .getResultList();

        // Consulta a quantidade de produtos associados ao leilão
        String quantidadeQuery = "SELECT COUNT(p.id) FROM Produto p WHERE p.leilao.id = :leilaoId";
        Long quantidadeProdutos = em.createQuery(quantidadeQuery, Long.class)
                .setParameter("leilaoId", leilaoId)
                .getSingleResult();

        // Construção do DTO usando o novo construtor
        return new DetalhesLeilaoDTO(
                leilao.getId(),
                leilao.getDataInicio(),
                leilao.getDataFim(),
                leilao.getDataVisita(),
                leilao.getDominioLeilaoEletronico(),
                leilao.getEndereco(),
                leilao.getCidade(),
                leilao.getEstado(),
                produtos,
                instFinanceiras,
                quantidadeProdutos.intValue()
        );
    }


}
