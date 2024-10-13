package beatrizbonatto.com.controller;

import beatrizbonatto.com.dto.LanceDTO;
import beatrizbonatto.com.service.LanceService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/lance")
public class LanceController {
    @Inject
    LanceService lanceService;

    @POST
    public Response createLance(LanceDTO lanceDTO) {
        try {
            lanceService.createLance(lanceDTO);
            return Response.status(Response.Status.CREATED).entity(lanceDTO).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getLance(@PathParam("id") Long id) {
       LanceDTO lanceDTO = lanceService.getLance(id);
        if (lanceDTO == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(lanceDTO).build();
    }

    @GET
    public List<LanceDTO> listLances() {
        return lanceService.listLances();
    }

    @PUT
    @Path("/{id}")
    public Response updateLance(@PathParam("id") Long id, LanceDTO lanceDTO) {
        LanceDTO updatedLance = lanceService.updateLance(id, lanceDTO);
        if (updatedLance == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(updatedLance).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteLance(@PathParam("id") Long id) {
        if (lanceService.deleteLance(id)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
