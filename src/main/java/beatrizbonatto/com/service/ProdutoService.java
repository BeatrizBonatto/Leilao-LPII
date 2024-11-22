package beatrizbonatto.com.service;

import beatrizbonatto.com.dto.ProdutoDTO;
import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.model.Produto;
import beatrizbonatto.com.repository.LeilaoRepository;
import beatrizbonatto.com.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class ProdutoService {
    @Inject
    ProdutoRepository produtoRepository;

    @Inject
    LeilaoRepository leilaoRepository;

    @Inject
    EntityManager em;

    @Transactional
    public void criarProduto(ProdutoDTO produtoDTO) {
        em.persist(produtoDTO);
    }

    public List<Produto> listaDeProdutos() {
        return produtoRepository.listaDeProdutos();
    }

    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.buscarProdutoPorId(id);
    }

    @Transactional
    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoAtualizado) {
        if(buscarProdutoPorId(id) != null) {
            em.merge(produtoAtualizado);
            return produtoAtualizado;
        }
        throw new IllegalArgumentException("Produto não existe");
    }

    @Transactional
    public boolean excluirProduto(Long id) {
        if(em.find(Produto.class, id) != null) {
            Produto produto = buscarProdutoPorId(id);
            em.remove(id);
            return true;
        }
        throw new IllegalArgumentException("Produto não existe");
    }

    public void desassociarProduto(Long produtoId, Long novoLeilaoId) {
        Produto produto = produtoRepository.buscarProdutoPorId(produtoId);

        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado");
        }

        if (produto.getLances() != null && !produto.getLances().isEmpty()) {
            throw new IllegalArgumentException("Não é possível desassociar um produto que já recebeu lances.");
        }

        Leilao novoLeilao = leilaoRepository.buscaLeilaoPorId(novoLeilaoId);

        if (novoLeilao.getDataInicio().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("O leilão deve ser futuro.");
        }

        produto.setLeilao(null);
        atualizarProduto(produtoId, toDTO(produto));

    }

    private ProdutoDTO toDTO(Produto produto) {
        return new ProdutoDTO(produto.getId(), produto.getSubTipo(), produto.getComplemento(), produto.getPrecoInicial(), produto.getLeilao(), produto.getLances());
    }
}
