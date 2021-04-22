package com.websocket.wstutorial.service;

import com.websocket.wstutorial.dto.ResponseMessage;
import com.websocket.wstutorial.quartz.playground.PlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;


@Service
public class WsService {

    private final SimpMessagingTemplate messagingTemplate;
    private final PlaygroundService playgroundService;

    @Autowired
    public WsService(SimpMessagingTemplate messagingTemplate, PlaygroundService playgroundService) {
        this.messagingTemplate = messagingTemplate;
        this.playgroundService = playgroundService;
    }

    public void notifyFrontend(final String message) {
        ResponseMessage response = new ResponseMessage(message);
        messagingTemplate.convertAndSend("/topic/messages", response);
    }

    public void notifyFrontendWithScheduledMessages() {
        playgroundService.runHelloWorldJob();
    }
}
