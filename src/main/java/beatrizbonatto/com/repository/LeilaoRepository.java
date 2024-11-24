package beatrizbonatto.com.repository;

import beatrizbonatto.com.dto.DetalhesLeilaoDTO;
import beatrizbonatto.com.model.Lance;
import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.model.Produto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.time.LocalDateTime;
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

    private String determinarStatusLeilao(Leilao leilao) {
        LocalDateTime agora = LocalDateTime.now();

        if (agora.isBefore(leilao.getDataInicio())) {
            return "EM ABERTO";
        } else if (agora.isAfter(leilao.getDataInicio()) && agora.isBefore(leilao.getDataFim())) {
            return "EM ANDAMENTO";
        } else {
            return "FINALIZADO";
        }
    }

    public DetalhesLeilaoDTO detalhesDoLeilaoPorId(Long leilaoId) {
        String leilaoQuery = "SELECT l FROM Leilao l WHERE l.id = :leilaoId";
        Leilao leilao = em.createQuery(leilaoQuery, Leilao.class)
                .setParameter("leilaoId", leilaoId)
                .getSingleResult();

        String produtosQuery = "SELECT p.nome FROM Produto p WHERE p.leilao.id = :leilaoId";
        List<String> produtos = em.createQuery(produtosQuery, String.class)
                .setParameter("leilaoId", leilaoId)
                .getResultList();

        String instFinanceirasQuery = "SELECT i.nome FROM InstFinanceira i JOIN i.leiloes l WHERE l.id = :leilaoId";
        List<String> instFinanceiras = em.createQuery(instFinanceirasQuery, String.class)
                .setParameter("leilaoId", leilaoId)
                .getResultList();

        String quantidadeQuery = "SELECT COUNT(p.id) FROM Produto p WHERE p.leilao.id = :leilaoId";
        Long quantidadeProdutos = em.createQuery(quantidadeQuery, Long.class)
                .setParameter("leilaoId", leilaoId)
                .getSingleResult();

        String status = determinarStatusLeilao(leilao);

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
                quantidadeProdutos.intValue(),
                status
        );
    }

    public List<Lance> buscarLancesPorValorMinMax(Long leilaoId, Double minimo, Double maximo) {
        String query = "SELECT la " +
                "FROM Lance la " +
                "WHERE la.produto.leilao.id = :leilaoId " +
                "AND la.valor BETWEEN :minimo AND :maximo";

        return em.createQuery(query, Lance.class)
                .setParameter("leilaoId", leilaoId)
                .setParameter("minimo", minimo)
                .setParameter("maximo", maximo)
                .getResultList();
    }

    public List<Lance> buscarLancesInicialPorValorMinMax(Long leilaoId, Double minimo, Double maximo) {
        String query = "SELECT la FROM Lance la " +
                "WHERE la.produto.leilao.id = :leilaoId " +
                "AND la.produto.precoInicial BETWEEN :minimo AND :maximo";

        return em.createQuery(query, Lance.class)
                .setParameter("leilaoId", leilaoId)
                .setParameter("minimo", minimo)
                .setParameter("maximo", maximo)
                .getResultList();
    }

    public List<Produto> buscarProdutosPorNomePorLeilao(String nome, Long leilaoId) {
        String query = "SELECT p FROM Produto p WHERE upper(p.nome) LIKE upper(:nome) AND p.leilao.id = :leilaoId";

        return em.createQuery(query, Produto.class)
                .setParameter("nome", "%" + nome + "%")
                .setParameter("leilaoId", leilaoId)
                .getResultList();
    }

    public List<Produto> buscarProdutosPorSubTipoPorLeilao(String subTipo, Long leilaoId) {
        String query = "SELECT p FROM Produto p WHERE upper(p.subTipo) LIKE upper(:subTipo) AND p.leilao.id = :leilaoId";

        return em.createQuery(query, Produto.class)
                .setParameter("subTipo", "%" + subTipo + "%")
                .setParameter("leilaoId", leilaoId)
                .getResultList();
    }

}
