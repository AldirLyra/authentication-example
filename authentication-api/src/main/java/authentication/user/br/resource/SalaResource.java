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

import authentication.user.br.dto.SalaDTO;
import authentication.user.br.model.Sala;
import authentication.user.br.services.SalaService;

@Path("/sala")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SalaResource {

    @Inject
    SalaService salaService;

    @GET
    public Response findAll() {
        List<Sala> salas = salaService.getAll();

        return Response.ok(salas).build();
    }

    @GET
    @Path("/search/{nome}")
    public Response findByName(String nome) {
        List<Sala> sala = salaService.getListSalas(nome);

        return Response.ok(sala).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        Sala sala = salaService.findById(id);
        return Response.ok(sala).build();
    }

    @POST
    public Response criar(SalaDTO salaDTO) {
        Sala sala = salaService.create(salaDTO);

        return Response.ok(sala).status(201).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, SalaDTO salaDTO) {
        salaService.update(id, salaDTO);
        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        salaService.delete(id);
        return Response.status(204).build();
    }
    
}
