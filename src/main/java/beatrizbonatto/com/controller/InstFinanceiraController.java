package beatrizbonatto.com.controller;

import beatrizbonatto.com.dto.InstFinanceiraDTO;
import beatrizbonatto.com.service.InstFinanceiraService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/instFinanceira")
public class InstFinanceiraController {
    @Inject
    InstFinanceiraService instFinanceiraService;

    @POST
    public Response criarInstFinanceira(InstFinanceiraDTO instFinanceiraDTO) {
        instFinanceiraService.criarInstFinanceira(instFinanceiraDTO);
        return Response.status(Response.Status.CREATED).entity(instFinanceiraDTO).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarInstFinanceira(@PathParam("id") Long id) {
       InstFinanceiraDTO instFinanceiraDTO = instFinanceiraService.buscarInstFinanceira(id);
        if (instFinanceiraDTO == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(instFinanceiraDTO).build();
    }

    @GET
    public List<InstFinanceiraDTO> listaDeInstFinanceira() {
        return instFinanceiraService.listaDeInstFinanceira();
    }

    @PUT
    @Path("/{id}")
    public Response atualizarInstFinanceira(@PathParam("id") Long id, InstFinanceiraDTO instFinanceiraDTO) {
        InstFinanceiraDTO updatedInstFinanceira = instFinanceiraService.atualizarInstFinanceira(id, instFinanceiraDTO);
        if (updatedInstFinanceira == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedInstFinanceira).build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluirInstFinanceira(@PathParam("id") Long id) {
        if (instFinanceiraService.excluirInstFinanceira(id)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
