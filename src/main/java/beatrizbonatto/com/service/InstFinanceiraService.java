package beatrizbonatto.com.service;

import beatrizbonatto.com.dto.InstFinanceiraDTO;
import beatrizbonatto.com.model.InstFinanceira;
import beatrizbonatto.com.repository.InstFinanceiraRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class InstFinanceiraService {
    @Inject
    InstFinanceiraRepository instFinanceiraRepository;

    public void createInstFinanceira(InstFinanceiraDTO instFinanceiraDTO) {
        InstFinanceira instFinanceira = new InstFinanceira();
        instFinanceira.setCodigo(instFinanceiraDTO.getCodigo());
        instFinanceira.setNome(instFinanceiraDTO.getNome());
        instFinanceira.setCnpj(instFinanceiraDTO.getCnpj());
        instFinanceiraRepository.registroInstFinanceira(instFinanceira);
    }

    public InstFinanceiraDTO getInstFinanceira(Long id) {
        InstFinanceira instFinanceira = instFinanceiraRepository.consultaInstFinanceira(id);
        if (instFinanceira != null) {
            return toDTO(instFinanceira);
        }
        return null;
    }

    public List<InstFinanceiraDTO> listInstFinanceiras() {
        return instFinanceiraRepository.listaDeInstFinanceira().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public InstFinanceiraDTO updateInstFinanceira(Long id, InstFinanceiraDTO instFinanceiraDTO) {
        InstFinanceira instFinanceira = instFinanceiraRepository.consultaInstFinanceira(id);
        if (instFinanceira != null) {
            instFinanceira.setCodigo(instFinanceiraDTO.getCodigo());
            instFinanceira.setNome(instFinanceiraDTO.getNome());
            instFinanceira.setCnpj(instFinanceiraDTO.getCnpj());
            instFinanceiraRepository.atualizar(instFinanceira);
            return toDTO(instFinanceira);
        }
        return null;
    }

    public boolean deleteInstFinanceira(Long id) {
        InstFinanceira instFinanceira = instFinanceiraRepository.consultaInstFinanceira(id);
        if (instFinanceira != null) {
            instFinanceiraRepository.remocao(id);
            return true;
        }
        return false;
    }

    private InstFinanceiraDTO toDTO(InstFinanceira instFinanceira) {
        return new InstFinanceiraDTO(instFinanceira.getCodigo(), instFinanceira.getNome(), instFinanceira.getCnpj());
    }
}
