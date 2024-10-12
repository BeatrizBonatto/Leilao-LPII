package beatrizbonatto.com.service;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import beatrizbonatto.com.model.Cliente;
import beatrizbonatto.com.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/cliente")
@ApplicationScoped
public class ClienteService {
    @Inject
    ClienteRepository clienteRepository;

    @POST
    @Operation(summary = "Criar um novo cliente")
    @APIResponse(responseCode = "201", description = "Cliente criado com sucesso.")
    public Response reCliente(Cliente cliente) {
        clienteRepository.registroCliente(cliente);
        return Response.status(Response.Status.CREATED).entity(cliente).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Buscar cliente por ID")
    @APIResponse(responseCode = "200", description = "Cliente encontrado.")
    @APIResponse(responseCode = "404", description = "Cliente não encontrado.")
    public Response consultaCliente(@PathParam("id") Long id) {
        Cliente cliente = clienteRepository.consultaCliente(id);
        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(cliente).build();
    }

    @GET
    @Operation(summary = "Listar todos os clientes")
    @APIResponse(responseCode = "200", description = "Lista de clientes.")
    public List<Cliente> listaDeClientes() {
        return ClienteRepository.listaDeClientes;
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Atualizar um cliente existente")
    @APIResponse(responseCode = "200", description = "Cliente atualizado com sucesso.")
    @APIResponse(responseCode = "404", description = "Cliente não encontrado.")
    public Response atualizarCliente(@PathParam("id") Long id, Cliente cliente) {
        Cliente clienteExistente = clienteRepository.consultaCliente(id);
        if (clienteExistente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        clienteExistente.setCpf(cliente.getCpf());
        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setCelular(cliente.getCelular());
        clienteExistente.setDataNascimento(cliente.getDataNascimento());
        clienteRepository.atualizar(clienteExistente);
        return Response.ok(clienteExistente).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Remover um cliente existente")
    @APIResponse(responseCode = "204", description = "Cliente removido com sucesso.")
    @APIResponse(responseCode = "404", description = "Cliente não encontrado.")
    public Response removerCliente(@PathParam("id") Long id) {
        Cliente cliente = clienteRepository.consultaCliente(id);
        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        clienteRepository.remocao(id);
        return Response.noContent().build();
    }
}
