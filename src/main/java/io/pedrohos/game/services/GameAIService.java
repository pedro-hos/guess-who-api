package io.pedrohos.game.services;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService
public interface GameAIService {
	
	@SystemMessage("Você deve me dar dicas")
	@UserMessage("""
            leia o texto {wikipediaLink} e forneça {clueListSize} itens em json
            """)
	String getClues(String wikipediaLink, int clueListSize);
}
