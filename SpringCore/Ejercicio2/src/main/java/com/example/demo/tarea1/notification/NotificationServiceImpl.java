package com.example.demo.tarea1.notification;

import com.example.demo.tarea1.message.IMessageService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@AllArgsConstructor
@Slf4j
public class NotificationServiceImpl implements INotificationService {
    
    private IMessageService facebookMessageService;
    private IMessageService twitterMessageService;
    private IMessageService emailMessageService;

    @Override
    public void notifyTo(String user, String message, NotificationType type) {
        log.info("Sending notification...");
        
        switch (type) {
            case FACEBOOK:
                facebookMessageService.sendMessage(user, message);
                break;
            case TWITTER:
                twitterMessageService.sendMessage(user, message);
                break;
            case EMAIL:
                emailMessageService.sendMessage(user, message);
                break;
            default:
                break;
        }
    }


}
