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

import authentication.user.br.dto.AlunoDTO;
import authentication.user.br.model.Aluno;
import authentication.user.br.services.AlunoService;

@Path("/aluno")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlunoResource {
    
    @Inject
    private AlunoService alunoService;

    @GET
    public Response findAll() {
        List<Aluno> alunos = alunoService.getAll();

        return Response.ok(alunos).build();
    }

    @GET
    @Path("/search/{nome}")
    public Response findByName(String nome) {
        List<Aluno> alunos = alunoService.getListAlunos(nome);

        return Response.ok(alunos).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Aluno aluno = alunoService.findById(id);
        return Response.ok(aluno).build();
    }

    @POST
    public Response criar(AlunoDTO alunoDTO) {
        Aluno aluno = alunoService.create(alunoDTO);

        return Response.ok(aluno).status(201).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, AlunoDTO alunoDTO) {
        alunoService.update(id, alunoDTO);
        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        alunoService.delete(id);
        return Response.status(204).build();
    }
}
