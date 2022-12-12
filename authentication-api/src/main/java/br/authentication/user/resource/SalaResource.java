package br.authentication.user.resource;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.authentication.user.dto.SalaDTO;
import br.authentication.user.model.Sala;
import br.authentication.user.services.SalaService;
import io.quarkus.security.Authenticated;

@Path("/sala")
@Authenticated
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SalaResource {

    @Inject
    SalaService salaService;

    @GET
    @RolesAllowed({"admin", "professor", "aluno"})
    public Response findAll() {
        List<Sala> salas = salaService.getAll();
        return Response.ok(salas).build();
    }

    @GET
    @RolesAllowed({"admin", "professor"})
    @Path("/search/{nome}")
    public Response findByName(String nome) {
        List<Sala> sala = salaService.getListSalas(nome);
        return Response.ok(sala).build();
    }

    @GET
    @RolesAllowed({"admin"})
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Sala sala = salaService.findById(id);
        return Response.ok(sala).build();
    }

    @POST
    @RolesAllowed({"admin"})
    public Response criar(SalaDTO salaDTO) {
        Sala sala = salaService.create(salaDTO);
        return Response.ok(sala).status(201).build();
    }

    @PUT
    @RolesAllowed({"admin"})
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, SalaDTO salaDTO) {
        salaService.update(id, salaDTO);
        return Response.status(204).build();
    }

    @DELETE
    @RolesAllowed({"admin"})
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        salaService.delete(id);
        return Response.status(204).build();
    }
    
}
