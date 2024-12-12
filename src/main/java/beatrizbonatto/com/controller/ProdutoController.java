package beatrizbonatto.com.controller;

import beatrizbonatto.com.dto.HubDTO;
import beatrizbonatto.com.dto.NotebookDTO;
import beatrizbonatto.com.dto.ProdutoDTO;
import beatrizbonatto.com.dto.RoteadorDTO;
import beatrizbonatto.com.model.Hub;
import beatrizbonatto.com.model.Notebook;
import beatrizbonatto.com.model.Produto;
import beatrizbonatto.com.model.Roteador;
import beatrizbonatto.com.service.ProdutoMapper;
import beatrizbonatto.com.service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

import java.util.List;

@Path("/produto")
public class ProdutoController {
    @Inject
    ProdutoService produtoService;

    @Inject
    ProdutoMapper produtoMapper;

    @POST
    @Path("/notebook")
    @Operation(summary = "Cria um novo notebook")
    public Response criarNotebook(NotebookDTO notebookDTO) {
        Notebook notebook = produtoService.criarNotebook(notebookDTO);

        return Response.ok().build();
    }

    @POST
    @Path("/hub")
    @Operation(summary = "Cria um novo hub")
    public Response criarHub(HubDTO hubDTO) {
        Hub hub = produtoService.criarHub(hubDTO);

        return Response.ok().build();
    }

    @POST
    @Path("/roteador")
    @Operation(summary = "Cria um novo roteador")
    public Response criarRoteador(RoteadorDTO roteadorDTO) {
        Roteador roteador = produtoService.criarRoteador(roteadorDTO);

        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Buscar um produto por id")
    public Response buscarProdutoPorId(@PathParam("id") Long id) {
        Produto produto = produtoService.buscarProdutoPorId(id);
        if (produto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        ProdutoDTO produtoDTO = produtoMapper.toDTO(produto);
        return Response.ok(produtoDTO).build();
    }

    @GET
    @Path("/{leilaoId}/{produtoId}")
    @Operation(summary = "Buscar um produto pelo id de leilao")
    public Produto buscarProdutoPorLeilao(@PathParam("leilaoId") Long leilaoId, @PathParam("produtoId") Long produtoId) {
        return produtoService.buscarProdutoPorLeilao(leilaoId, produtoId);
    }

    @GET
    @Operation(summary = "Lista de produto")
    public List<Produto> listaDeProdutos() {
        return produtoService.listaDeProdutos();
    }

    @PUT
    @Path("/{id}")
    @Operation(summary = "Atualizar produto, buscando pelo id")
    public Response atualizarProduto(@PathParam("id") Long id, ProdutoDTO produtoDTO) {
        try {
            ProdutoDTO updatedProduto = produtoService.atualizarProduto(id, produtoDTO);
            if (updatedProduto == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.ok(updatedProduto).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Excluir produto, buscando pelo id")
    public Response excluirProduto(@PathParam("id") Long id) {
        try {
            if (produtoService.excluirProduto(id)) {
                return Response.noContent().build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{produtoId}/{novoLeilaoId}")
    @Operation(summary = "Desassociar produto, buscando pelo id")
    public Response desassociarProduto(@PathParam("produtoId") Long produtoId, @PathParam("novoLeilaoId") Long novoLeilaoId) {
        try {
            produtoService.desassociarProduto(produtoId, novoLeilaoId);
            return Response.ok().build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
