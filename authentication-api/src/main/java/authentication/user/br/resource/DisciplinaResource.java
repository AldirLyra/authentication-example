package authentication.user.br.resource;

import java.util.List;

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

import authentication.user.br.dto.DisciplinaDTO;
import authentication.user.br.model.Disciplina;
import authentication.user.br.services.DisciplinaService;

@Path("/disciplina")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DisciplinaResource {

    @Inject
    private DisciplinaService disciplinaService;

    @GET
    public Response findAll() {
        List<Disciplina> disciplina = disciplinaService.getAll();

        return Response.ok(disciplina).build();
    }

    @GET
    @Path("/search/{nome}")
    public Response findByName(String nome) {
        List<Disciplina> disciplina = disciplinaService.getListDisciplinas(nome);

        return Response.ok(disciplina).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Disciplina aluno = disciplinaService.findById(id);
        return Response.ok(aluno).build();
    }

    @POST
    public Response criar(DisciplinaDTO alunoDTO) {
        Disciplina aluno = disciplinaService.create(alunoDTO);

        return Response.ok(aluno).status(201).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, DisciplinaDTO alunoDTO) {
        disciplinaService.update(id, alunoDTO);
        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        disciplinaService.delete(id);
        return Response.status(204).build();
    }
    
}
