package io.pedrohos.game.resources;

import io.pedrohos.game.model.States;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author pedro-hos
 */

@Path("/states")
@Produces(MediaType.APPLICATION_JSON)
public class StatesResource {
	
	@GET
	public Response all() {
		return Response.ok(States.findAll().list()).build();
	}

}
