package com.example.demo.tarea1.message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwitterMessageServiceImpl implements IMessageService {

    @Override
    public void sendMessage(String user, String message) {
        log.info("Mensaje a Twitter: {} => para {}", message, user);
    }
    
}
