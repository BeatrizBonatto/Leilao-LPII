package beatrizbonatto.com.service;

import beatrizbonatto.com.dto.*;
import beatrizbonatto.com.model.*;
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
            notebook.setCor(notebookDTO.getCor());
            notebook.setMarca(notebookDTO.getMarca());
            notebook.setLeilao(leilao);

            produtoRepository.salvar(notebook);
            return notebook;
        } else {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }
    }

    @Transactional
    public Hub criarHub(HubDTO hubDTO) {

        Leilao leilao = leilaoRepository.buscaLeilaoPorId(hubDTO.getIdLeilao());

        if (leilao == null) {
            throw new IllegalArgumentException("Leilão com o ID fornecido não existe!");
        }

        if(hubDTO.getNome() != null && hubDTO.getPrecoInicial() != null) {
            Hub hub = new Hub();
            hub.setNome(hubDTO.getNome());
            hub.setPrecoInicial(hubDTO.getPrecoInicial());
            hub.setCor(hubDTO.getCor());
            hub.setMarca(hubDTO.getMarca());
            hub.setLeilao(leilao);

            produtoRepository.salvar(hub);
            return hub;
        } else {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }
    }

    @Transactional
    public Roteador criarRoteador(RoteadorDTO roteadorDTO) {

        Leilao leilao = leilaoRepository.buscaLeilaoPorId(roteadorDTO.getIdLeilao());

        if (leilao == null) {
            throw new IllegalArgumentException("Leilão com o ID fornecido não existe!");
        }

        if(roteadorDTO.getNome() != null && roteadorDTO.getPrecoInicial() != null) {
            Roteador roteador = new Roteador();
            roteador.setNome(roteadorDTO.getNome());
            roteador.setPrecoInicial(roteadorDTO.getPrecoInicial());
            roteador.setCor(roteadorDTO.getCor());
            roteador.setMarca(roteadorDTO.getMarca());
            roteador.setVelocidadeWiFi(roteadorDTO.getVelocidadeWiFi());
            roteador.setLeilao(leilao);

            produtoRepository.salvar(roteador);
            return roteador;
        } else {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }
    }

    @Transactional
    public Switch criarSwitch(SwitchDTO switchDTO) {

        Leilao leilao = leilaoRepository.buscaLeilaoPorId(switchDTO.getIdLeilao());

        if (leilao == null) {
            throw new IllegalArgumentException("Leilão com o ID fornecido não existe!");
        }

        if(switchDTO.getNome() != null && switchDTO.getPrecoInicial() != null) {
            Switch switch1 = new Switch();
            switch1.setNome(switchDTO.getNome());
            switch1.setPrecoInicial(switchDTO.getPrecoInicial());
            switch1.setCor(switchDTO.getCor());
            switch1.setMarca(switchDTO.getMarca());
            switch1.setGerenciavel(switchDTO.getGerenciavel());
            switch1.setLeilao(leilao);

            produtoRepository.salvar(switch1);
            return switch1;
        } else {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }
    }

    @Transactional
    public Caminhao criarCaminhao(CaminhaoDTO caminhaoDTO) {

        Leilao leilao = leilaoRepository.buscaLeilaoPorId(caminhaoDTO.getIdLeilao());

        if (leilao == null) {
            throw new IllegalArgumentException("Leilão com o ID fornecido não existe!");
        }

        if(caminhaoDTO.getNome() != null && caminhaoDTO.getPrecoInicial() != null) {
            Caminhao caminhao = new Caminhao();
            caminhao.setNome(caminhaoDTO.getNome());
            caminhao.setPrecoInicial(caminhaoDTO.getPrecoInicial());
            caminhao.setCor(caminhaoDTO.getCor());
            caminhao.setPlaca(caminhaoDTO.getPlaca());
            caminhao.setCor(caminhaoDTO.getCor());
            caminhao.setQuantidadeEixo(caminhaoDTO.getQuantidadeEixo());
            caminhao.setLeilao(leilao);

            produtoRepository.salvar(caminhao);
            return caminhao;
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

}
