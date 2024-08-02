package io.pedrohos.game.services;

import java.util.random.RandomGenerator;

import io.pedrohos.game.model.Cards;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

/**
 * @author pedro-hos
 */

@ApplicationScoped
public class GameService {
	
	public Cards startGame(String state, String city) {
		
		long count = Cards.count("city.name = ?1 and city.state.name=?2", city, state);
		
		if(count == 0) {
			throw new NotFoundException("Can't find the city " + city + ", or State: " + state + " on our database.");
		}
		
		int pageIndex = RandomGenerator.of("L128X256MixRandom").nextInt((int)count);
		return Cards.randomByStateAndCity(state, city, pageIndex);
	}
	
}
