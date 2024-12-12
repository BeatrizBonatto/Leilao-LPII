package beatrizbonatto.com.controller;

import beatrizbonatto.com.dto.*;
import beatrizbonatto.com.model.*;
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

    @POST
    @Path("/switch")
    @Operation(summary = "Cria um novo switch")
    public Response criarSwitch(SwitchDTO switchDTO) {
        Switch switch1 = produtoService.criarSwitch(switchDTO);

        return Response.ok().build();
    }

    @POST
    @Path("/caminhao")
    @Operation(summary = "Cria um novo caminhao")
    public Response criarCaminhao(CaminhaoDTO caminhaoDTO) {
        Caminhao caminhao = produtoService.criarCaminhao(caminhaoDTO);

        return Response.ok().build();
    }

    @POST
    @Path("/carro")
    @Operation(summary = "Cria um novo carro")
    public Response criarCarro(CarroDTO carroDTO) {
        Carro carro = produtoService.criarCarro(carroDTO);

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
    @Path("/notebook/{id}")
    @Operation(summary = "Atualizar notebook, buscando pelo id")
    public Response atualizarNotebook(@PathParam("id") Long id, NotebookDTO notebookDTO) {
        try {
            Notebook updatedProduto = produtoService.atualizarNotebook(id, notebookDTO);
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
