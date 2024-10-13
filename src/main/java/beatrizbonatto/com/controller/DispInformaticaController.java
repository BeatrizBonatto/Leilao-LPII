package beatrizbonatto.com.controller;

import beatrizbonatto.com.dto.DispInformaticaDTO;
import beatrizbonatto.com.service.DispInformaticaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/dispInformatica")
public class DispInformaticaController {
    @Inject
    DispInformaticaService dispInformaticaService;

    @POST
    public Response createDispInformatica(DispInformaticaDTO dispInformaticaDTO) {
        dispInformaticaService.createDispInformatica(dispInformaticaDTO);
        return Response.status(Response.Status.CREATED).entity(dispInformaticaDTO).build();
    }

    @GET
    @Path("/{id}")
    public Response getDispInformatica(@PathParam("id") Long id) {
       DispInformaticaDTO dispInformaticaDTO = dispInformaticaService.getDispInformatica(id);
        if (dispInformaticaDTO == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(dispInformaticaDTO).build();
    }

    @GET
    public List<DispInformaticaDTO> listDispInformaticas() {
        return dispInformaticaService.listDispInformaticas();
    }

    @PUT
    @Path("/{id}")
    public Response updateDispInformatica(@PathParam("id") Long id, DispInformaticaDTO dispInformaticaDTO) {
        DispInformaticaDTO updatedDispInformatica = dispInformaticaService.updateDispInformatica(id, dispInformaticaDTO);
        if (updatedDispInformatica == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedDispInformatica).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDispInformatica(@PathParam("id") Long id) {
        if (dispInformaticaService.deleteDispInformatica(id)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
