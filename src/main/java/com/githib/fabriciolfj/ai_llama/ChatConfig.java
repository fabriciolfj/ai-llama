package com.githib.fabriciolfj.ai_llama;

import org.springframework.ai.autoconfigure.ollama.OllamaConnectionProperties;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConfig {

    @Bean
    public ChatClient chatClient(OllamaConnectionProperties properties) {
        var ollamaApi = new OllamaApi(properties.getBaseUrl());

        return ChatClient.builder(OllamaChatModel.builder()
                        .withOllamaApi(ollamaApi)
                        .build())
                .build();
    }
}