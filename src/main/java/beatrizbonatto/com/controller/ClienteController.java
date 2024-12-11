package beatrizbonatto.com.controller;

import beatrizbonatto.com.dto.ClienteDTO;
import beatrizbonatto.com.model.Cliente;
import beatrizbonatto.com.service.ClienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

import java.util.List;

@Path("/cliente")
public class ClienteController {
    @Inject
    ClienteService clienteService;

    @POST
    @Path("/criar")
    @Operation(summary = "Cria um novo cliente")
    public Response criarCliente(ClienteDTO clienteDTO) {
        clienteService.criarCliente(clienteDTO);
        return Response.status(Response.Status.CREATED).entity(clienteDTO).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Buscar um cliente por id")
    public Response buscarClientePorId(@PathParam("id") Long id) {
       Cliente cliente = clienteService.buscarClientePorId(id);
        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(cliente).build();
    }

    @GET
    @Operation(summary = "Lista de clientes")
    public List<Cliente> listaDeClientes() {
        return clienteService.listaDeClientes();
    }

    @PUT
    @Path("atualizar/{id}")
    @Operation(summary = "Atualizar cliente, buscando pelo id")
    public Response atualizarCliente(@PathParam("id") Long id, ClienteDTO clienteDTO) {
        ClienteDTO novoCliente = clienteService.atualizarCliente(id, clienteDTO);
        if (novoCliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(novoCliente).build();
    }

    @DELETE
    @Path("excluir/{id}")
    @Operation(summary = "Excluir cliente, buscando pelo id")
    public Response excluirCliente(@PathParam("id") Long id) {
        if (clienteService.excluirCliente(id)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
