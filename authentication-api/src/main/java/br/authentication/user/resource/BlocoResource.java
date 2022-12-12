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

import br.authentication.user.dto.BlocoDTO;
import br.authentication.user.model.Bloco;
import br.authentication.user.services.BlocoService;
import io.quarkus.security.Authenticated;

@Path("/bloco")
@Authenticated
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BlocoResource {

    @Inject
    private BlocoService blocoService;

    @GET
    @RolesAllowed({"admin", "professor", "aluno"})
    public Response findAll() {
        List<Bloco> blocos = blocoService.getAll();
        return Response.ok(blocos).build();
    }

    @GET
    @RolesAllowed({"professor", "admin"})
    @Path("/search/{nome}")
    public Response findByName(String nome) {
        List<Bloco> bloco = blocoService.getListBlocos(nome);
        return Response.ok(bloco).build();
    }

    @GET
    @RolesAllowed({"admin"})
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Bloco bloco = blocoService.findById(id);
        return Response.ok(bloco).build();
    }

    @POST
    @RolesAllowed({"admin"})
    public Response criar(BlocoDTO blocoDTO) {
        Bloco bloco = blocoService.create(blocoDTO);
        return Response.ok(bloco).status(201).build();
    }

    @PUT
    @RolesAllowed({"admin"})
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, BlocoDTO blocoDTO) {
        blocoService.update(id, blocoDTO);
        return Response.status(204).build();
    }

    @DELETE
    @RolesAllowed({"admin"})
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        blocoService.delete(id);
        return Response.status(204).build();
    }
    
}
