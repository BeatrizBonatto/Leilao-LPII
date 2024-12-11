package beatrizbonatto.com.controller;

import beatrizbonatto.com.dto.InstFinanceiraDTO;
import beatrizbonatto.com.model.InstFinanceira;
import beatrizbonatto.com.service.InstFinanceiraService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

import java.util.List;

@Path("/instFinanceira")
public class InstFinanceiraController {
    @Inject
    InstFinanceiraService instFinanceiraService;

    @POST
    @Path("/criar")
    @Operation(summary = "Cria instituicao financeira")
    public Response criarInstFinanceira(InstFinanceiraDTO instFinanceiraDTO) {
        instFinanceiraService.criarInstFinanceira(instFinanceiraDTO);
        return Response.status(Response.Status.CREATED).entity(instFinanceiraDTO).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Buscar instituicao financeira por id")
    public Response buscarInstFinanceira(@PathParam("id") Long id) {
       InstFinanceira instFinanceira = instFinanceiraService.buscarInstFinanceira(id);
        if (instFinanceira == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(instFinanceira).build();
    }

    @GET
    @Operation(summary = "Lista de instituicoes")
    public List<InstFinanceira> listaDeInstFinanceira() {
        return instFinanceiraService.listaDeInstFinanceira();
    }

    @PUT
    @Path("atualizar/{id}")
    @Operation(summary = "Atualizar instituicao financeira, buscando pelo id")
    public Response atualizarInstFinanceira(@PathParam("id") Long id, InstFinanceiraDTO instFinanceiraDTO) {
        InstFinanceiraDTO updatedInstFinanceira = instFinanceiraService.atualizarInstFinanceira(id, instFinanceiraDTO);
        if (updatedInstFinanceira == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedInstFinanceira).build();
    }

    @DELETE
    @Path("excluir/{id}")
    @Operation(summary = "Excluir instituicao financeira, buscando pelo id")
    public Response excluirInstFinanceira(@PathParam("id") Long id) {
        if (instFinanceiraService.excluirInstFinanceira(id)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
