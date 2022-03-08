package com.example.demo.tarea1.message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FacebookMessageServiceImpl implements IMessageService {

    @Override
    public void sendMessage(String user, String message) {
        log.info("Mensaje a FB: {} => para {}", message, user);
    }
    
}
