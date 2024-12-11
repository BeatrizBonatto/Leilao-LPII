package beatrizbonatto.com.service;

import beatrizbonatto.com.dto.ClienteDTO;
import beatrizbonatto.com.model.Cliente;
import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ClienteService {
    @Inject
    ClienteRepository clienteRepository;

    @Inject
    EntityManager em;

    @Transactional
    public void criarCliente(ClienteDTO clienteDTO) {
        Cliente toSave = new Cliente();
        toSave.setNome(clienteDTO.getNome());
        toSave.setCpf(clienteDTO.getCpf());
        toSave.setDataNascimento(clienteDTO.getDataNascimento());
        toSave.setLances(clienteDTO.getLances());

        clienteRepository.salvar(toSave);
    }

    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.ClientePorId(id);
    }

    public List<Cliente> listaDeClientes() {
        return clienteRepository.listaDeClientes();
    }

    @Transactional
    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteAtualizado) {
        if(buscarClientePorId(id) != null) {
            em.merge(clienteAtualizado);
            return clienteAtualizado;
        }
        throw new IllegalArgumentException("Cliente não existe");
    }

    @Transactional
    public boolean excluirCliente(Long id) {
        if(em.find(Cliente.class, id) != null) {
            Cliente cliente = buscarClientePorId(id);
            em.remove(cliente);
            return true;
        }
        throw new IllegalArgumentException("Cliente não existe");
    }

    private ClienteDTO toDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getNome(), cliente.getCpf(), cliente.getDataNascimento(), cliente.getLances());
    }
}