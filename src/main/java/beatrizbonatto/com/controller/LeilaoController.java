package beatrizbonatto.com.controller;

import beatrizbonatto.com.dto.DetalhesLeilaoDTO;
import beatrizbonatto.com.dto.LeilaoDTO;
import beatrizbonatto.com.model.Lance;
import beatrizbonatto.com.model.Leilao;
import beatrizbonatto.com.model.Produto;
import beatrizbonatto.com.service.LeilaoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

import java.util.List;

@Path("/leilao")
public class LeilaoController {
    @Inject
    LeilaoService leilaoService;

    @POST
    @Operation(summary = "Cria um novo leilao")
    public Response criarLeilao(LeilaoDTO leilaoDTO) {
        leilaoService.criarLeilao(leilaoDTO);
        return Response.status(Response.Status.CREATED).entity(leilaoDTO).build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Buscar um leilao por id")
    public Response buscaLeilaoPorId(@PathParam("id") Long id) {
       Leilao leilao = leilaoService.buscaLeilaoPorId(id);
        if (leilao == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(leilao).build();
    }

    @GET
    @Path("/lista")
    @Operation(summary = "Lista de leiloes")
    public List<Leilao> listaDeLeiloes() {
        return leilaoService.listaDeLeiloes();
    }

    @GET
    @Path("/lista_por_data")
    @Operation(summary = "Lista de leiloes por data de evento")
    public List<Leilao> listaDeLeiloesOrdenadoPorDataEvento() {
        return leilaoService.listaDeLeiloesOrdenadoPorDataEvento();
    }

    @GET
    @Path("/detalhes/{id}")
    @Operation(summary = "Detalhes do leilao, busca por id")
    public DetalhesLeilaoDTO detalhesDoLeilaoPorId(@PathParam("id") Long leilaoId) {
        return leilaoService.detalhesDoLeilaoPorId(leilaoId);
    }

    @GET
    @Path("/lances/{id}/{min}/{max}")
    @Operation(summary = "Buscar lances por valor minimo e maximo e por id do leilao")
    public List<Lance> buscarLancesPorValorMinMax(@PathParam("id") Long leilaoId, @PathParam("min") Double minimo, @PathParam("max") Double maximo) {
        return leilaoService.buscarLancesPorValorMinMax(leilaoId, minimo, maximo);
    }

    @GET
    @Path("/lance_inicial/{id}/{min}/{max}")
    @Operation(summary = "Buscar lances minimos por valor minimo e maximo e por id do leilao")
    public List<Lance> buscarLancesInicialPorValorMinMax(@PathParam("id") Long leilaoId, @PathParam("min") Double minimo, @PathParam("max") Double maximo) {
        return leilaoService.buscarLancesPorValorMinMax(leilaoId, minimo, maximo);
    }

    @GET
    @Path("nome_produto/{id}/{nome}")
    @Operation(summary = "Buscar produtos por nome e por id do leilao")
    public List<Produto> buscarProdutosPorNomePorLeilao(@PathParam("id") Long leilaoId, @PathParam("nome") String nome) {
        return leilaoService.buscarProdutosPorNomePorLeilao(nome, leilaoId);
    }

//    @GET
//    @Path("/subtipo_produto/{id}/{subtipo}")
//    @Operation(summary = "Buscar produtos por tipo e por id do leilao")
//    public List<Produto> buscarProdutosPorSubTipoPorLeilao(@PathParam("subtipo") String subTipo, @PathParam("id") Long leilaoId) {
//        return leilaoService.buscarProdutosPorSubTipoPorLeilao(subTipo, leilaoId);
//    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Atualizar leilao, buscando pelo id")
    public Response atualizarLeilao(@PathParam("id") Long id, LeilaoDTO leilaoDTO) {
        LeilaoDTO updatedLeilao = leilaoService.atualizarLeilao(id, leilaoDTO);
        if (updatedLeilao == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedLeilao).build();
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Excluir leilao, buscando pelo id")
    public Response excluirLeilao(@PathParam("id") Long id) {
        if (leilaoService.excluirLeilao(id)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
