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
    public Response criarLeilao(LeilaoDTO leilaoDTO) {
        leilaoService.createLeilao(leilaoDTO);
        return Response.status(Response.Status.CREATED).entity(leilaoDTO).build();
    }

    @GET
    @Path("/{id}")
    public Response buscaLeilaoPorId(@PathParam("id") Long id) {
       LeilaoDTO leilaoDTO = leilaoService.buscaLeilaoPorId(id);
        if (leilaoDTO == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(leilaoDTO).build();
    }

    @GET
    public List<LeilaoDTO> listaDeLeiloes() {
        return leilaoService.listaDeLeiloes();
    }

    @PUT
    @Path("/{id}")
    public Response atualizarLeilao(@PathParam("id") Long id, LeilaoDTO leilaoDTO) {
        LeilaoDTO updatedLeilao = leilaoService.atualizarLeilao(id, leilaoDTO);
        if (updatedLeilao == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedLeilao).build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluirLeilao(@PathParam("id") Long id) {
        if (leilaoService.excluirLeilao(id)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
