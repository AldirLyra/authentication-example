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

import br.authentication.user.dto.DisciplinaDTO;
import br.authentication.user.model.Disciplina;
import br.authentication.user.services.DisciplinaService;
import io.quarkus.security.Authenticated;

@Path("/disciplina")
@Authenticated
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DisciplinaResource {

    @Inject
    private DisciplinaService disciplinaService;

    @GET
    @RolesAllowed({"admin", "professor", "aluno"})
    public Response findAll() {
        List<Disciplina> disciplina = disciplinaService.getAll();
        return Response.ok(disciplina).build();
    }

    @GET
    @RolesAllowed({"admin", "professor", "aluno"})
    @Path("/search/{nome}")
    public Response findByName(String nome) {
        List<Disciplina> disciplina = disciplinaService.getListDisciplinas(nome);
        return Response.ok(disciplina).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"admin"})
    public Response findById(@PathParam("id") Long id) {
        Disciplina aluno = disciplinaService.findById(id);
        return Response.ok(aluno).build();
    }

    @POST
    @RolesAllowed({"admin"})
    public Response criar(DisciplinaDTO alunoDTO) {
        Disciplina aluno = disciplinaService.create(alunoDTO);
        return Response.ok(aluno).status(201).build();
    }

    @PUT
    @RolesAllowed({"admin"})
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, DisciplinaDTO alunoDTO) {
        disciplinaService.update(id, alunoDTO);
        return Response.status(204).build();
    }

    @DELETE
    @RolesAllowed({"admin"})
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        disciplinaService.delete(id);
        return Response.status(204).build();
    }
    
}
