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

import br.authentication.user.dto.ProfessorDTO;
import br.authentication.user.model.Professor;
import br.authentication.user.services.ProfessorService;
import io.quarkus.security.Authenticated;

@Path("/professor")
@Authenticated
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfessorResource {

    @Inject
    private ProfessorService professorService;

    @GET
    @RolesAllowed({"professor", "admin"})
    public Response findAll() {
        List<Professor> professores = professorService.getAll();
        return Response.ok(professores).build();
    }

    @GET
    @RolesAllowed({"professor", "admin"})
    @Path("/search/{nome}")
    public Response findByName(String nome) {
        List<Professor> professores = professorService.getListProfessors(nome);
        return Response.ok(professores).build();
    }

    @GET
    @RolesAllowed({"admin"})
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Professor professor = professorService.findById(id);
        return Response.ok(professor).build();
    }

    @POST
    @RolesAllowed({"admin"})
    public Response criar(ProfessorDTO professorDTO) {
        Professor professor = professorService.create(professorDTO);
        return Response.ok(professor).status(201).build();
    }

    @PUT
    @RolesAllowed({"admin"})
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ProfessorDTO professorDTO) {
        professorService.update(id, professorDTO);
        return Response.status(204).build();
    }

    @DELETE
    @RolesAllowed({"admin"})
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        professorService.delete(id);
        return Response.status(204).build();
    }
    
}
