package beatrizbonatto.com.service;

import beatrizbonatto.com.dto.DispInformaticaDTO;
import beatrizbonatto.com.model.DispInformatica;
import beatrizbonatto.com.repository.DispInformaticaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class DispInformaticaService {
    @Inject
    DispInformaticaRepository dispInformaticaRepository;

    public void createDispInformatica(DispInformaticaDTO dispInformaticaDTO) {
        DispInformatica dispInformatica = new DispInformatica();
        dispInformatica.setTipoDispositivo(dispInformaticaDTO.getTipoDispositivo());
        dispInformatica.setMarca(dispInformaticaDTO.getMarca());
        dispInformatica.setModelo(dispInformaticaDTO.getModelo());
        dispInformaticaRepository.registroDispInformatica(dispInformatica);
    }

    public DispInformaticaDTO getDispInformatica(Long id) {
        DispInformatica dispInformatica = dispInformaticaRepository.consultaDispInformatica(id);
        if (dispInformatica != null) {
            return toDTO(dispInformatica);
        }
        return null;
    }

    public List<DispInformaticaDTO> listDispInformaticas() {
        return dispInformaticaRepository.listaDeDispInformatica().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public DispInformaticaDTO updateDispInformatica(Long id, DispInformaticaDTO dispInformaticaDTO) {
        DispInformatica dispInformatica = dispInformaticaRepository.consultaDispInformatica(id);
        if (dispInformatica != null) {
            dispInformatica.setTipoDispositivo(dispInformaticaDTO.getTipoDispositivo());
            dispInformatica.setMarca(dispInformaticaDTO.getMarca());
            dispInformatica.setModelo(dispInformaticaDTO.getModelo());
            dispInformaticaRepository.atualizar(dispInformatica);
            return toDTO(dispInformatica);
        }
        return null;
    }

    public boolean deleteDispInformatica(Long id) {
        DispInformatica dispInformatica = dispInformaticaRepository.consultaDispInformatica(id);
        if (dispInformatica != null) {
            dispInformaticaRepository.remocao(id);
            return true;
        }
        return false;
    }

    private DispInformaticaDTO toDTO(DispInformatica dispInformatica) {
        return new DispInformaticaDTO(dispInformatica.getTipoDispositivo(), dispInformatica.getModelo(), dispInformatica.getMarca());
    }
}
