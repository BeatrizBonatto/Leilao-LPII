package beatrizbonatto.com.service;

import beatrizbonatto.com.dto.ClienteDTO;
import beatrizbonatto.com.model.Cliente;
import beatrizbonatto.com.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClienteService {
    @Inject
    ClienteRepository clienteRepository;

    public void createCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setCelular(clienteDTO.getCelular());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setDataNascimento(clienteDTO.getDataNascimento());
        clienteRepository.registroCliente(cliente);
    }

    public ClienteDTO getCliente(Long id) {
        Cliente cliente = clienteRepository.consultaCliente(id);
        if (cliente != null) {
            return toDTO(cliente);
        }
        return null;
    }

    public List<ClienteDTO> listClientes() {
        return clienteRepository.listaDeClientes().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.consultaCliente(id);
        if (cliente != null) {
            cliente.setNome(clienteDTO.getNome());
            cliente.setCpf(clienteDTO.getCpf());
            cliente.setCelular(clienteDTO.getCelular());
            cliente.setEmail(clienteDTO.getEmail());
            cliente.setDataNascimento(clienteDTO.getDataNascimento());
            clienteRepository.atualizar(cliente);
            return toDTO(cliente);
        }
        return null;
    }

    public boolean deleteCliente(Long id) {
        Cliente cliente = clienteRepository.consultaCliente(id);
        if (cliente != null) {
            clienteRepository.remocao(id);
            return true;
        }
        return false;
    }

    private ClienteDTO toDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getNome(), cliente.getCpf(), cliente.getCelular(), cliente.getEmail(), cliente.getDataNascimento());
    }
}
