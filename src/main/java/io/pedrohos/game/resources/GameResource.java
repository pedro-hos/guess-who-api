package io.pedrohos.game.resources;

import io.pedrohos.game.services.GameAIService;
import io.pedrohos.game.services.GameService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

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
	
//	@GET
//	public Response start(@QueryParam("state") String state, @QueryParam("city") String city) {
//		return Response.ok(ai.getClues(game.startGame(state, city).contentPage, 5)).build();
//	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String start(@QueryParam("state") String state, @QueryParam("city") String city) {
		return ai.getClues(game.startGame(state, city).answer, 5);
	}
	
	/*
	 * @GET
	 * 
	 * @Path("/bla") public void bla() {
	 * 
	 * var path =
	 * "/home/pesilva/Workspace/code/pessoal/guess-who/guess-who-api/src/main/resources/catalog/";
	 * 
	 * Stream<Cards> streamAll = Cards.streamAll(); streamAll.forEach(c -> { var
	 * fileName = c.answer.replaceAll(" ", "_").concat(".txt"); try {
	 * Files.write(Paths.get("src/main/resources/catalog/" + fileName),
	 * c.contentPage.getBytes()); } catch (IOException e) { e.printStackTrace(); }
	 * }); }
	 */
	
}
