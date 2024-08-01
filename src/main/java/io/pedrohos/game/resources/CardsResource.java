package io.pedrohos.game.resources;

import io.pedrohos.game.model.Cards;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author pedro-hos
 */

@Path("/cards")
@Produces(MediaType.APPLICATION_JSON)
public class CardsResource {
	
	@GET
	public Response all() {
		return Response.ok(Cards.findAll().list()).build();
	}

}
