package io.pedrohos.game.resources;

import io.pedrohos.game.services.GameAIService;
import io.pedrohos.game.services.GameService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author pedro-hos
 */

@Path("/game")
@Produces(MediaType.APPLICATION_JSON)
public class GameResource {
	
	@Inject
	GameService game;
	
	@Inject
	GameAIService ai;
	
	@GET
	public Response start(@QueryParam("state") String state, @QueryParam("city") String city) {
		return Response.ok(game.startGame(state, city)).build();
	}
	
	@GET
	@Path("/teste")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return ai.getClues("https://pt.wikipedia.org/wiki/Geovanna_Tominaga", 3);
	}

}
