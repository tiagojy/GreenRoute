package com.greenroute.gemini;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import io.github.cdimascio.dotenv.Dotenv;

public class ConexaoGemini {

    private final ChatLanguageModel model;

    public ConexaoGemini() {

        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("GEMINI_API_KEY");

        model = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.5-flash")
                .build();
    }

    public String perguntar(String pergunta) {

        ChatRequest request = ChatRequest.builder()
                .messages(UserMessage.from(pergunta))
                .build();

        ChatResponse response = model.chat(request);

        return response.aiMessage().text();
    }
}