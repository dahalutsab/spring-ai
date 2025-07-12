package com.utsab.ai.chat;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/openai")
@CrossOrigin("*")
public class ChatController {

    private final OpenAiChatModel chatModel;

    public ChatController(OpenAiChatModel chatModel){
        this.chatModel = chatModel;
    }

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){

        String response = chatModel.call(message);

        return ResponseEntity.ok(response);
    }

}
