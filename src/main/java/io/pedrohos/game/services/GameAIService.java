package io.pedrohos.game.services;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.SessionScoped;

@RegisterAiService(retrievalAugmentor = Retriever.class)
@SessionScoped
public interface GameAIService {
	
	@SystemMessage("Você deve me dar dicas")
	@UserMessage("""
            quero {clueListSize} dicas para adivinhar quem é {content} em formato de lista
            """)
	String getClues(String content, int clueListSize);
}
