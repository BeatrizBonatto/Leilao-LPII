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
    public Response createInstFinanceira(InstFinanceiraDTO instFinanceiraDTO) {
        instFinanceiraService.createInstFinanceira(instFinanceiraDTO);
        return Response.status(Response.Status.CREATED).entity(instFinanceiraDTO).build();
    }

    @GET
    @Path("/{id}")
    public Response getInstFinanceira(@PathParam("id") Long id) {
       InstFinanceiraDTO instFinanceiraDTO = instFinanceiraService.getInstFinanceira(id);
        if (instFinanceiraDTO == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(instFinanceiraDTO).build();
    }

    @GET
    public List<InstFinanceiraDTO> listInstFinanceiras() {
        return instFinanceiraService.listInstFinanceiras();
    }

    @PUT
    @Path("/{id}")
    public Response updateInstFinanceira(@PathParam("id") Long id, InstFinanceiraDTO instFinanceiraDTO) {
        InstFinanceiraDTO updatedInstFinanceira = instFinanceiraService.updateInstFinanceira(id, instFinanceiraDTO);
        if (updatedInstFinanceira == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedInstFinanceira).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteInstFinanceira(@PathParam("id") Long id) {
        if (instFinanceiraService.deleteInstFinanceira(id)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
