package beatrizbonatto.com.controller;

import beatrizbonatto.com.dto.ClienteDTO;
import beatrizbonatto.com.service.ClienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/cliente")
public class ClienteController {
    @Inject
    ClienteService clienteService;

    @POST
    public Response createCliente(ClienteDTO clienteDTO) {
        clienteService.createCliente(clienteDTO);
        return Response.status(Response.Status.CREATED).entity(clienteDTO).build();
    }

    @GET
    @Path("/{id}")
    public Response getCliente(@PathParam("id") Long id) {
       ClienteDTO clienteDTO = clienteService.getCliente(id);
        if (clienteDTO == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(clienteDTO).build();
    }

    @GET
    public List<ClienteDTO> listClientes() {
        return clienteService.listClientes();
    }

    @PUT
    @Path("/{id}")
    public Response updateCliente(@PathParam("id") Long id, ClienteDTO clienteDTO) {
        ClienteDTO updatedCliente = clienteService.updateCliente(id, clienteDTO);
        if (updatedCliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedCliente).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCliente(@PathParam("id") Long id) {
        if (clienteService.deleteCliente(id)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
