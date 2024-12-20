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

    @Transactional
    public Carro criarCarro(CarroDTO carroDTO) {

        Leilao leilao = leilaoRepository.buscaLeilaoPorId(carroDTO.getIdLeilao());

        if (leilao == null) {
            throw new IllegalArgumentException("Leilão com o ID fornecido não existe!");
        }

        if(carroDTO.getNome() != null && carroDTO.getPrecoInicial() != null) {
            Carro carro = new Carro();
            carro.setNome(carroDTO.getNome());
            carro.setPrecoInicial(carroDTO.getPrecoInicial());
            carro.setCor(carroDTO.getCor());
            carro.setPlaca(carroDTO.getPlaca());
            carro.setCor(carroDTO.getCor());
            carro.setTipoDeCambio(carroDTO.getTipoDeCambio());
            carro.setLeilao(leilao);

            produtoRepository.salvar(carro);
            return carro;
        } else {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }
    }

    @Transactional
    public Moto criarMoto(MotoDTO motoDTO) {

        Leilao leilao = leilaoRepository.buscaLeilaoPorId(motoDTO.getIdLeilao());

        if (leilao == null) {
            throw new IllegalArgumentException("Leilão com o ID fornecido não existe!");
        }

        if(motoDTO.getNome() != null && motoDTO.getPrecoInicial() != null) {
            Moto moto = new Moto();
            moto.setNome(motoDTO.getNome());
            moto.setPrecoInicial(motoDTO.getPrecoInicial());
            moto.setCor(motoDTO.getCor());
            moto.setPlaca(motoDTO.getPlaca());
            moto.setCor(motoDTO.getCor());
            moto.setCilindrada(motoDTO.getCilindrada());
            moto.setLeilao(leilao);

            produtoRepository.salvar(moto);
            return moto;
        } else {
            throw new IllegalArgumentException("Todos os campos devem ser preenchidos");
        }
    }

    @Transactional
    public Utilitario criarUtilitario(UtilitarioDTO utilitarioDTO) {

        Leilao leilao = leilaoRepository.buscaLeilaoPorId(utilitarioDTO.getIdLeilao());

        if (leilao == null) {
            throw new IllegalArgumentException("Leilão com o ID fornecido não existe!");
        }

        if(utilitarioDTO.getNome() != null && utilitarioDTO.getPrecoInicial() != null) {
            Utilitario utilitario = new Utilitario();
            utilitario.setNome(utilitarioDTO.getNome());
            utilitario.setPrecoInicial(utilitarioDTO.getPrecoInicial());
            utilitario.setCor(utilitarioDTO.getCor());
            utilitario.setPlaca(utilitarioDTO.getPlaca());
            utilitario.setCor(utilitarioDTO.getCor());
            utilitario.setCapacidadePassageiros(utilitarioDTO.getCapacidadePassageiros());
            utilitario.setLeilao(leilao);

            produtoRepository.salvar(utilitario);
            return utilitario;
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
    public Notebook atualizarNotebook(Long id, NotebookDTO notebookAtualizado) {
        if(buscarProdutoPorId(id) != null) {

            Leilao leilao = leilaoRepository.buscaLeilaoPorId(notebookAtualizado.getIdLeilao());

            if (leilao == null) {
                throw new IllegalArgumentException("Leilão com o ID fornecido não existe!");
            }

            Notebook notebook = new Notebook();
            notebook.setId(id);
            notebook.setNome(notebookAtualizado.getNome());
            notebook.setPrecoInicial(notebookAtualizado.getPrecoInicial());
            notebook.setCor(notebookAtualizado.getCor());
            notebook.setMarca(notebookAtualizado.getMarca());
            notebook.setPolegada(notebookAtualizado.getPolegada());
            notebook.setLeilao(leilao);

            produtoRepository.salvar(notebook);
            return notebook;
        }
        throw new IllegalArgumentException("Produto não existe");
    }

    @Transactional
    public Hub atualizarHub(Long id, HubDTO produtoAtualizado) {
        if(buscarProdutoPorId(id) != null) {

            Leilao leilao = leilaoRepository.buscaLeilaoPorId(produtoAtualizado.getIdLeilao());

            if (leilao == null) {
                throw new IllegalArgumentException("Leilão com o ID fornecido não existe!");
            }

            Hub hub = new Hub();
            hub.setId(id);
            hub.setNome(produtoAtualizado.getNome());
            hub.setPrecoInicial(produtoAtualizado.getPrecoInicial());
            hub.setCor(produtoAtualizado.getCor());
            hub.setMarca(produtoAtualizado.getMarca());
            hub.setQuantidadePortas(produtoAtualizado.getQuantidadePortas());
            hub.setLeilao(leilao);

            produtoRepository.salvar(hub);
            return hub;
        }
        throw new IllegalArgumentException("Produto não existe");
    }

    @Transactional
    public Roteador atualizarRoteador(Long id, RoteadorDTO produtoAtualizado) {
        if(buscarProdutoPorId(id) != null) {

            Leilao leilao = leilaoRepository.buscaLeilaoPorId(produtoAtualizado.getIdLeilao());

            if (leilao == null) {
                throw new IllegalArgumentException("Leilão com o ID fornecido não existe!");
            }

            Roteador roteador = new Roteador();
            roteador.setId(id);
            roteador.setNome(produtoAtualizado.getNome());
            roteador.setPrecoInicial(produtoAtualizado.getPrecoInicial());
            roteador.setCor(produtoAtualizado.getCor());
            roteador.setMarca(produtoAtualizado.getMarca());
            roteador.setVelocidadeWiFi(produtoAtualizado.getVelocidadeWiFi());
            roteador.setLeilao(leilao);

            produtoRepository.salvar(roteador);
            return roteador;
        }
        throw new IllegalArgumentException("Produto não existe");
    }

    @Transactional
    public Switch atualizarSwitch(Long id, SwitchDTO produtoAtualizado) {
        if(buscarProdutoPorId(id) != null) {

            Leilao leilao = leilaoRepository.buscaLeilaoPorId(produtoAtualizado.getIdLeilao());

            if (leilao == null) {
                throw new IllegalArgumentException("Leilão com o ID fornecido não existe!");
            }

            Switch switch1 = new Switch();
            switch1.setId(id);
            switch1.setNome(produtoAtualizado.getNome());
            switch1.setPrecoInicial(produtoAtualizado.getPrecoInicial());
            switch1.setCor(produtoAtualizado.getCor());
            switch1.setMarca(produtoAtualizado.getMarca());
            switch1.setGerenciavel(produtoAtualizado.getGerenciavel());
            switch1.setLeilao(leilao);

            produtoRepository.salvar(switch1);
            return switch1;
        }
        throw new IllegalArgumentException("Produto não existe");
    }

    @Transactional
    public Caminhao atualizarCaminhao(Long id, CaminhaoDTO produtoAtualizado) {
        if(buscarProdutoPorId(id) != null) {

            Leilao leilao = leilaoRepository.buscaLeilaoPorId(produtoAtualizado.getIdLeilao());

            if (leilao == null) {
                throw new IllegalArgumentException("Leilão com o ID fornecido não existe!");
            }

            Caminhao caminhao = new Caminhao();
            caminhao.setNome(produtoAtualizado.getNome());
            caminhao.setPrecoInicial(produtoAtualizado.getPrecoInicial());
            caminhao.setCor(produtoAtualizado.getCor());
            caminhao.setPlaca(produtoAtualizado.getPlaca());
            caminhao.setCor(produtoAtualizado.getCor());
            caminhao.setQuantidadeEixo(produtoAtualizado.getQuantidadeEixo());
            caminhao.setLeilao(leilao);

            produtoRepository.salvar(caminhao);
            return caminhao;
        }
        throw new IllegalArgumentException("Produto não existe");
    }

    @Transactional
    public Carro atualizarCarro(Long id, CarroDTO produtoAtualizado) {
        if(buscarProdutoPorId(id) != null) {

            Leilao leilao = leilaoRepository.buscaLeilaoPorId(produtoAtualizado.getIdLeilao());

            if (leilao == null) {
                throw new IllegalArgumentException("Leilão com o ID fornecido não existe!");
            }

            Carro carro = new Carro();
            carro.setNome(produtoAtualizado.getNome());
            carro.setPrecoInicial(produtoAtualizado.getPrecoInicial());
            carro.setCor(produtoAtualizado.getCor());
            carro.setPlaca(produtoAtualizado.getPlaca());
            carro.setCor(produtoAtualizado.getCor());
            carro.setLeilao(leilao);
            carro.setTipoDeCambio(produtoAtualizado.getTipoDeCambio());
            produtoRepository.salvar(carro);
            return carro;
        }
        throw new IllegalArgumentException("Produto não existe");
    }

    @Transactional
    public Moto atualizarMoto(Long id, MotoDTO produtoAtualizado) {
        if(buscarProdutoPorId(id) != null) {

            Leilao leilao = leilaoRepository.buscaLeilaoPorId(produtoAtualizado.getIdLeilao());

            if (leilao == null) {
                throw new IllegalArgumentException("Leilão com o ID fornecido não existe!");
            }

            Moto moto = new Moto();
            moto.setNome(produtoAtualizado.getNome());
            moto.setPrecoInicial(produtoAtualizado.getPrecoInicial());
            moto.setCor(produtoAtualizado.getCor());
            moto.setPlaca(produtoAtualizado.getPlaca());
            moto.setCor(produtoAtualizado.getCor());
            moto.setCilindrada(produtoAtualizado.getCilindrada());
            moto.setLeilao(leilao);

            produtoRepository.salvar(moto);
            return moto;
        }
        throw new IllegalArgumentException("Produto não existe");
    }

    @Transactional
    public Utilitario atualizarUtilitario(Long id, UtilitarioDTO produtoAtualizado) {
        if(buscarProdutoPorId(id) != null) {

            Leilao leilao = leilaoRepository.buscaLeilaoPorId(produtoAtualizado.getIdLeilao());

            if (leilao == null) {
                throw new IllegalArgumentException("Leilão com o ID fornecido não existe!");
            }

            Utilitario utilitario = new Utilitario();
            utilitario.setNome(produtoAtualizado.getNome());
            utilitario.setPrecoInicial(produtoAtualizado.getPrecoInicial());
            utilitario.setCor(produtoAtualizado.getCor());
            utilitario.setPlaca(produtoAtualizado.getPlaca());
            utilitario.setCor(produtoAtualizado.getCor());
            utilitario.setCapacidadePassageiros(produtoAtualizado.getCapacidadePassageiros());
            utilitario.setLeilao(leilao);

            produtoRepository.salvar(utilitario);
            return utilitario;
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
        //atualizarNotebook(produtoId, toDTO(produto));
    }


    private ProdutoDTO toDTO(Produto produto) {
        return new ProdutoDTO(produto.getNome(), produto.getDescricao(), produto.getPrecoInicial(),produto.getLeilao().getId());
    }

}
