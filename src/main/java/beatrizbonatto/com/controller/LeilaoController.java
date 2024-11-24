package beatrizbonatto.com.controller;

import beatrizbonatto.com.dto.DetalhesLeilaoDTO;
import beatrizbonatto.com.dto.LeilaoDTO;
import beatrizbonatto.com.model.Lance;
import beatrizbonatto.com.model.Leilao;
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
        leilaoService.criarLeilao(leilaoDTO);
        return Response.status(Response.Status.CREATED).entity(leilaoDTO).build();
    }

    @GET
    @Path("/{id}")
    public Response buscaLeilaoPorId(@PathParam("id") Long id) {
       Leilao leilao = leilaoService.buscaLeilaoPorId(id);
        if (leilao == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(leilao).build();
    }

    @GET
    @Path("/lista")
    public List<Leilao> listaDeLeiloes() {
        return leilaoService.listaDeLeiloes();
    }

    @GET
    @Path("/lista_por_data")
    public List<Leilao> listaDeLeiloesOrdenadoPorDataEvento() {
        return leilaoService.listaDeLeiloesOrdenadoPorDataEvento();
    }

    @GET
    @Path("/detalhes/{id}")
    public DetalhesLeilaoDTO detalhesDoLeilaoPorId(@PathParam("id") Long leilaoId) {
        return leilaoService.detalhesDoLeilaoPorId(leilaoId);
    }

    @GET
    @Path("/{id}/{min}/{max}")
    public List<Lance> buscarLancesPorValorMinMax(@PathParam("id") Long leilaoId, @PathParam("min") Double minimo, @PathParam("max") Double maximo) {
        return leilaoService.buscarLancesPorValorMinMax(leilaoId, minimo, maximo);
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
