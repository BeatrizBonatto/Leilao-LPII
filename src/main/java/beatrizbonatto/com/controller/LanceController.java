package beatrizbonatto.com.controller;

import beatrizbonatto.com.dto.HistoricoLancesDTO;
import beatrizbonatto.com.dto.LanceDTO;
import beatrizbonatto.com.model.Lance;
import beatrizbonatto.com.service.LanceService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

import java.util.List;

@Path("/lance")
public class LanceController {
    @Inject
    LanceService lanceService;

    @POST
    @Operation(summary = "Cria um novo lance")
    public Response criarLance(LanceDTO lanceDTO) {
        try {
            lanceService.criarLance(lanceDTO);
            return Response.status(Response.Status.CREATED).entity(lanceDTO).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/lance_produto/{id}")
    @Operation(summary = "Buscar um lance por id")
    public Response buscarLancePorId(@PathParam("id") Long id) {
       Lance lance = lanceService.buscarLancePorId(id);
        if (lance == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(lance).build();
    }

    @GET
    @Operation(summary = "Lista de lances")
    public List<Lance> listaDeLances() {
        return lanceService.listaDeLances();
    }

    @GET
    @Path("/produto/{idProduto}/historico-lances")
    @Operation(summary = "Buscar historico de lances por id de produto")
    public List<HistoricoLancesDTO> buscarHistoricoLancesPorProduto(@PathParam("idProduto") Long produtoId) {
        return lanceService.buscarHistoricoLancesPorProduto(produtoId);
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Atualizar lance, buscando pelo id")
    public Response atualizarLance(@PathParam("id") Long id, LanceDTO lanceDTO) {
        LanceDTO updatedLance = lanceService.atualizarLance(id, lanceDTO);
        if (updatedLance == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedLance).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Excluir lance, buscando pelo id")
    public Response excluirLance(@PathParam("id") Long id) {
        if (lanceService.excluirLance(id)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
