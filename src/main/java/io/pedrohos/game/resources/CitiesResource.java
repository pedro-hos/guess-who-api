package io.pedrohos.game.resources;

import io.pedrohos.game.model.Cities;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author pedro-hos
 */

@Path("/cities")
@Produces(MediaType.APPLICATION_JSON)
public class CitiesResource {
	
	@GET
	public Response all() {
		return Response.ok(Cities.findAll().list()).build();
	}

}
