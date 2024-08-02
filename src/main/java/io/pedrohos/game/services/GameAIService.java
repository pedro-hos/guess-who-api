package io.pedrohos.game.services;

import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(tools = GameService.class)
public interface GameAIService {
	
	//@SystemMessage("Você deve me dar dicas")
	@UserMessage("""
            Faça um resumo com {clueListSize} itens do texto {wikipediaLink} em formato de lista.
            """)
	String getClues(String wikipediaLink, int clueListSize);
}
