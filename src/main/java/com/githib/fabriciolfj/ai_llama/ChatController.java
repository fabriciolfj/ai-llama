package com.githib.fabriciolfj.ai_llama;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;

import java.util.List;


@RestController
public class ChatController {

    private final ChatClient chatClient;

    @Autowired
    public ChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    record ChatRequest(String message) {}

    @PostMapping("/chat")
    public String chat(@RequestBody ChatRequest request) {
        return chatClient.prompt(request.message())
                .call().content();
    }

    @PostMapping("/chat/with-system")
    public String chatWithSystem(@RequestBody ChatRequest request) {
        Message systemMessage = new SystemMessage("Você é um assistente prestativo e amigável.");
        Message userMessage = new UserMessage(request.message());
        Prompt prompt = new Prompt(List.of(systemMessage, userMessage));
        ChatResponse response = chatClient.prompt(prompt).call().chatResponse();
        assert response != null;
        return response.getResult().getOutput().getContent();
    }
}