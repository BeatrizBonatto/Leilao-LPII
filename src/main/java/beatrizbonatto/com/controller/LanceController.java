package beatrizbonatto.com.controller;

import beatrizbonatto.com.dto.LanceDTO;
import beatrizbonatto.com.service.LanceService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/lance")
public class LanceController {
    @Inject
    LanceService lanceService;

    @POST
    public Response criarLance(LanceDTO lanceDTO) {
        try {
            lanceService.criarLance(lanceDTO);
            return Response.status(Response.Status.CREATED).entity(lanceDTO).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response buscarLancePorId(@PathParam("id") Long id) {
       LanceDTO lanceDTO = lanceService.buscarLancePorId(id);
        if (lanceDTO == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(lanceDTO).build();
    }

    @GET
    public List<LanceDTO> listaDeLances() {
        return lanceService.listaDeLances();
    }

    @PUT
    @Path("/{id}")
    public Response atualizarLance(@PathParam("id") Long id, LanceDTO lanceDTO) {
        LanceDTO updatedLance = lanceService.atualizarLance(id, lanceDTO);
        if (updatedLance == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedLance).build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluirLance(@PathParam("id") Long id) {
        if (lanceService.excluirLance(id)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
