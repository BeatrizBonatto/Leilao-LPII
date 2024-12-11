package beatrizbonatto.com.service;

import beatrizbonatto.com.dto.NotebookDTO;
import beatrizbonatto.com.dto.ProdutoDTO;
import beatrizbonatto.com.model.Lance;
import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.model.Produto;
import beatrizbonatto.com.model.Notebook;
import beatrizbonatto.com.repository.LanceRepository;
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
    LanceRepository lanceRepository;

    @Inject
    EntityManager em;

//    @Transactional
//    public void criarProduto(ProdutoDTO produtoDTO) {
//        if(produtoDTO.getSubTipo() != null && produtoDTO.getNome() != null && produtoDTO.getLeilao() != null) {
//            em.persist(produtoDTO);
//        } else {
//            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
//        }
//    }

    @Transactional
    public Notebook criarNotebook(NotebookDTO notebookDTO) {

        Leilao leilao = leilaoRepository.buscaLeilaoPorId(notebookDTO.getIdLeilao());

        if (leilao == null) {
            throw new IllegalArgumentException("Leilão com o ID fornecido não existe!");
        }

        if(notebookDTO.getNome() != null && notebookDTO.getPrecoInicial() != null && notebookDTO.getPolegada() != null) {
            Notebook notebook = new Notebook();
            notebook.setNome(notebookDTO.getNome());
            notebook.setPrecoInicial(notebookDTO.getPrecoInicial());
            notebook.setPolegada(notebookDTO.getPolegada());
            notebook.setLeilao(leilao);

            produtoRepository.salvar(notebook);
            return notebook;
        } else {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }
    }

    public List<Produto> listaDeProdutos() {
        return produtoRepository.listaDeProdutos();
    }

    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.buscarProdutoPorId(id);
    }

    public Produto buscarProdutoPorLeilao(Long leilaoId, Long produtoId){
        return produtoRepository.buscarProdutoPorLeilao(leilaoId, produtoId);
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

        Lance lancesAssociados = lanceRepository.buscarLancesPorProdutoId(produtoId);

        if (lancesAssociados != null) {
            throw new IllegalArgumentException("Não é possível desassociar um produto que já recebeu lances.");
        }

        Leilao novoLeilao = leilaoRepository.buscaLeilaoPorId(novoLeilaoId);

        if (novoLeilao == null) {
            throw new IllegalArgumentException("Novo leilão não encontrado.");
        }

        if (novoLeilao.getDataInicio().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("O leilão deve ser futuro.");
        }

        produto.setLeilao(novoLeilao);
        atualizarProduto(produtoId, toDTO(produto));
    }


    private ProdutoDTO toDTO(Produto produto) {
        return new ProdutoDTO(produto.getNome(), produto.getDescricao(), produto.getPrecoInicial(),produto.getLeilao().getId());
    }

    public ProdutoDTO toDTO2(Produto produto) {
        if (produto instanceof Notebook) {
            Notebook notebook = (Notebook) produto;
            return new NotebookDTO(
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPrecoInicial(),
                    produto.getLeilao().getId(),
                    notebook.getPolegada()
            );
        } /*else if (produto instanceof Carro) {
            Carro carro = (Carro) produto;
            return new CarroDTO(
                    produto.getId(),
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPrecoInicial(),
                    produto.getLeilao().getId(),
                    carro.getNumeroDePortas()
            );
        } else if (produto instanceof Monitor) {
            Monitor monitor = (Monitor) produto;
            return new MonitorDTO(
                    produto.getId(),
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPrecoInicial(),
                    produto.getLeilao().getId(),
                    monitor.getResolucao()
            );
        }*/
        return null;
    }

}
