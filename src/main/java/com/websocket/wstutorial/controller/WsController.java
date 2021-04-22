package com.websocket.wstutorial.controller;

import com.websocket.wstutorial.dto.Message;
import com.websocket.wstutorial.service.WsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WsController {

    @Autowired
    private WsService service;

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody final Message message) {
        service.notifyFrontend(message.getMessageContent());
    }

    @PostMapping("/trigger-messages")
    public void sendScheduledMessages() {
        service.notifyFrontendWithScheduledMessages();
    }
}
