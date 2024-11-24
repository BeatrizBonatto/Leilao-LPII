package beatrizbonatto.com.service;

import beatrizbonatto.com.dto.LeilaoDTO;
import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.repository.LeilaoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class LeilaoService {
    @Inject
    LeilaoRepository leilaoRepository;

    @Inject
    EntityManager em;

    @Transactional
    public void createLeilao(LeilaoDTO leilaoDTO) {
        if (leilaoDTO.getInstFinanceira() == null || leilaoDTO.getInstFinanceira().toString() == "") {
            throw new IllegalArgumentException("Cada leilão deve ter ao menos uma entidade financeira associada.");
        }

        em.persist(leilaoDTO);
    }

    public Leilao buscaLeilaoPorId(Long id) {
        return leilaoRepository.buscaLeilaoPorId(id);
    }

    public List<Leilao> listaDeLeiloes() {
        return leilaoRepository.listaDeLeiloes();
    }

    @Transactional
    public LeilaoDTO atualizarLeilao(Long id, LeilaoDTO leilaoAtualizado) {
        if(buscaLeilaoPorId(id) != null) {
            em.merge(leilaoAtualizado);
            return leilaoAtualizado;
        }
        throw new IllegalArgumentException("Cliente não existe");
    }

    @Transactional
    public boolean excluirLeilao(Long id) {
        if(buscaLeilaoPorId(id) != null) {
            em.remove(id);
            return true;
        }
        throw new IllegalArgumentException("Cliente não existe");
    }

    public List<Leilao> listaDeLeiloesOrdenadoPorDataEvento() {
        return leilaoRepository.listaDeLeiloesOrdenadoPorDataEvento();
    }

    private LeilaoDTO toDTO(Leilao leilao) {
        return new LeilaoDTO(leilao.getId() ,
                leilao.getDataInicio(), leilao.getDataFim(), leilao.getDataVisita(),
                leilao.getDominioLeilaoEletronico(),
                leilao.getEndereco(), leilao.getCidade(), leilao.getEstado(),
                leilao.getProdutos(), leilao.getInstFinanceira()
        );
    }
}
