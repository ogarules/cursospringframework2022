package com.example.demo.tarea1.message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwitterMessageServiceImpl implements IMessageService {

    @Override
    public void sendMessage(String user, String message) {
        log.info("Mensage a twitter: {} => enviad a {}", message, user);
        
    }
    
}
