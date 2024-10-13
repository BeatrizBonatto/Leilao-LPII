package beatrizbonatto.com.controller;

import beatrizbonatto.com.dto.LeilaoDTO;
import beatrizbonatto.com.service.LeilaoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/leilao")
public class LeilaoController {
    @Inject
    LeilaoService leilaoService;

    @POST
    public Response createLeilao(LeilaoDTO leilaoDTO) {
        leilaoService.createLeilao(leilaoDTO);
        return Response.status(Response.Status.CREATED).entity(leilaoDTO).build();
    }

    @GET
    @Path("/{id}")
    public Response getLeilao(@PathParam("id") Long id) {
       LeilaoDTO leilaoDTO = leilaoService.getLeilao(id);
        if (leilaoDTO == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(leilaoDTO).build();
    }

    @GET
    public List<LeilaoDTO> listLeilaos() {
        return leilaoService.listLeiloes();
    }

    @PUT
    @Path("/{id}")
    public Response updateLeilao(@PathParam("id") Long id, LeilaoDTO leilaoDTO) {
        LeilaoDTO updatedLeilao = leilaoService.updateLeilao(id, leilaoDTO);
        if (updatedLeilao == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedLeilao).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteLeilao(@PathParam("id") Long id) {
        if (leilaoService.deleteLeilao(id)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
