package beatrizbonatto.com.controller;

import beatrizbonatto.com.dto.ProdutoDTO;
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
    public Response createProduto(ProdutoDTO produtoDTO) {
        try {
            produtoService.createProduto(produtoDTO);
            return Response.status(Response.Status.CREATED).entity(produtoDTO).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getProduto(@PathParam("id") Long id) {
       ProdutoDTO produtoDTO = produtoService.getProduto(id);
        if (produtoDTO == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(produtoDTO).build();
    }

    @GET
    public List<ProdutoDTO> listProdutos() {
        return produtoService.listProdutos();
    }

    @PUT
    @Path("/{id}")
    public Response updateProduto(@PathParam("id") Long id, ProdutoDTO produtoDTO) {
        try {
            ProdutoDTO updatedProduto = produtoService.updateProduto(id, produtoDTO);
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
    public Response deleteProduto(@PathParam("id") Long id) {
        try {
            if (produtoService.deleteProduto(id)) {
                return Response.noContent().build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
