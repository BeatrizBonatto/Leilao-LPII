package beatrizbonatto.com.controller;

import beatrizbonatto.com.dto.VeiculoDTO;
import beatrizbonatto.com.service.VeiculoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/veiculo")
public class VeiculoController {
    @Inject
    VeiculoService veiculoService;

    @POST
    public Response createVeiculo(VeiculoDTO veiculoDTO) {
        veiculoService.createVeiculo(veiculoDTO);
        return Response.status(Response.Status.CREATED).entity(veiculoDTO).build();
    }

    @GET
    @Path("/{id}")
    public Response getVeiculo(@PathParam("id") Long id) {
       VeiculoDTO veiculoDTO = veiculoService.getVeiculo(id);
        if (veiculoDTO == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(veiculoDTO).build();
    }

    @GET
    public List<VeiculoDTO> listVeiculos() {
        return veiculoService.listVeiculos();
    }

    @PUT
    @Path("/{id}")
    public Response updateVeiculo(@PathParam("id") Long id, VeiculoDTO veiculoDTO) {
        VeiculoDTO updatedVeiculo = veiculoService.updateVeiculo(id, veiculoDTO);
        if (updatedVeiculo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedVeiculo).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteVeiculo(@PathParam("id") Long id) {
        if (veiculoService.deleteVeiculo(id)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
