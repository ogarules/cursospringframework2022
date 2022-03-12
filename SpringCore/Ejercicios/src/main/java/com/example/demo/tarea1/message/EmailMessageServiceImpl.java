package com.example.demo.tarea1.message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailMessageServiceImpl implements IMessageService {

    @Override
    public void sendMessage(String user, String message) {
        log.info("Mensage a email: {} => enviad a {}", message, user);
        
    }
    
}
