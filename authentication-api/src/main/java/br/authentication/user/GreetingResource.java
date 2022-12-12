package br.authentication.user;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.security.Authenticated;

@Path("/hello")
@Authenticated
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("aluno")
    @RolesAllowed({"aluno", "admin"})
    public String helloAluno() {
        return "Olá aluno!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("professor")
    @RolesAllowed({"professor", "admin"})
    public String helloProfessor() {
        return "Olá professor!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("admin")
    @RolesAllowed("admin")
    public String helloAdmin() {
        return "Olá admin!";
    }
}