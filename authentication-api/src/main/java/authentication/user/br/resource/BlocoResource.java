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

import authentication.user.br.dto.BlocoDTO;
import authentication.user.br.model.Bloco;
import authentication.user.br.services.BlocoService;

@Path("/bloco")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BlocoResource {

    @Inject
    private BlocoService blocoService;

    @GET
    public Response findAll() {
        List<Bloco> blocos = blocoService.getAll();

        return Response.ok(blocos).build();
    }

    @GET
    @Path("/search/{nome}")
    public Response findByName(String nome) {
        List<Bloco> bloco = blocoService.getListBlocos(nome);

        return Response.ok(bloco).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Bloco bloco = blocoService.findById(id);
        return Response.ok(bloco).build();
    }

    @POST
    public Response criar(BlocoDTO blocoDTO) {
        Bloco bloco = blocoService.create(blocoDTO);

        return Response.ok(bloco).status(201).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, BlocoDTO blocoDTO) {
        blocoService.update(id, blocoDTO);
        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        blocoService.delete(id);
        return Response.status(204).build();
    }
    
}
