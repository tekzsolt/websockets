package com.websocket.wstutorial.service;

import com.websocket.wstutorial.dto.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;


@Service
public class WsService {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public WsService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void notifyFrontend(final String message) {
        ResponseMessage response = new ResponseMessage(message);
        messagingTemplate.convertAndSend("/topic/messages", response);
    }
}
