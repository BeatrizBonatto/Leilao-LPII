package beatrizbonatto.com.service;

import beatrizbonatto.com.dto.ProdutoDTO;
import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.model.Produto;
import beatrizbonatto.com.repository.LeilaoRepository;
import beatrizbonatto.com.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProdutoService {
    @Inject
    ProdutoRepository produtoRepository;

    @Inject
    LeilaoRepository leilaoRepository;

    public void createProduto(ProdutoDTO produtoDTO) {
        Leilao leilao = leilaoRepository.consultaLeilao(produtoDTO.getLeilao().getId());
        if (leilao == null) {
            throw new IllegalStateException("Leilão não encontrado.");
        }

        Produto produto = new Produto();
        produto.setTipo(produtoDTO.getTipo());
        produto.setComplemento(produtoDTO.getComplemento());
        produto.setPrecoInicial(produtoDTO.getPrecoInicial());
        produto.setStatus(produtoDTO.getStatus());
        produto.setLeilao(leilao);
        produto.setLances(produtoDTO.getLances());
        produtoRepository.registroProduto(produto);
    }

    public ProdutoDTO getProduto(Long id) {
        Produto produto = produtoRepository.consultaProduto(id);
        if (produto != null) {
            return toDTO(produto);
        }
        return null;
    }

    public List<ProdutoDTO> listProdutos() {
        return produtoRepository.listaDeProdutos().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ProdutoDTO updateProduto(Long id, ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository.consultaProduto(id);
        if (produto != null) {
            Leilao leilao = leilaoRepository.consultaLeilao(produtoDTO.getLeilao().getId());
            if (leilao == null) {
                throw new IllegalStateException("Leilão não encontrado.");
            }

            produto.setTipo(produtoDTO.getTipo());
            produto.setComplemento(produtoDTO.getComplemento());
            produto.setPrecoInicial(produtoDTO.getPrecoInicial());
            produto.setStatus(produtoDTO.getStatus());
            produto.setLeilao(leilao);
            produto.setLances(produtoDTO.getLances());
            produtoRepository.atualizar(produto);
            return toDTO(produto);
        }
        return null;
    }

    public boolean deleteProduto(Long id) {
        Produto produto = produtoRepository.consultaProduto(id);
        if (produto != null && produto.getLances().isEmpty()) {
            produtoRepository.remocao(id);
            return true;
        } else if (produto != null) {
            throw new IllegalStateException("O produto já recebeu lances e não pode ser removido.");
        }
        return false;
    }

    private ProdutoDTO toDTO(Produto produto) {
        return new ProdutoDTO(produto.getTipo(), produto.getComplemento(), produto.getPrecoInicial(), produto.getStatus(), produto.getLeilao(), produto.getLances());
    }
}
