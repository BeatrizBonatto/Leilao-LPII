package beatrizbonatto.com.controller;

import beatrizbonatto.com.dto.ProdutoDTO;
import beatrizbonatto.com.model.Produto;
import beatrizbonatto.com.service.ProdutoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/produto")
public class ProdutoController {
    @Inject
    ProdutoService produtoService;

    @POST
    public Response criarProduto(ProdutoDTO produtoDTO) {
        try {
            produtoService.criarProduto(produtoDTO);
            return Response.status(Response.Status.CREATED).entity(produtoDTO).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response buscarProdutoPorId(@PathParam("id") Long id) {
       Produto produto = produtoService.buscarProdutoPorId(id);
        if (produto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(produto).build();
    }

    @GET
    public List<Produto> listaDeProdutos() {
        return produtoService.listaDeProdutos();
    }

    @PUT
    @Path("/{id}")
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
    @Path("/{produtoId}/desassociar/{novoLeilaoId}")
    public Response desassociarProduto(@PathParam("produtoId") Long produtoId, @PathParam("novoLeilaoId") Long novoLeilaoId) {
        try {
            produtoService.desassociarProduto(produtoId, novoLeilaoId);
            return Response.ok().build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
