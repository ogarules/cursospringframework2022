package com.example.demo.tarea1.notification;

import com.example.demo.tarea1.message.IMessageService;

public interface INotificationService {
    
    IMessageService getFacebookMessageService();
    IMessageService getTwitterMessageService();
    IMessageService getEmailMessageService();
    
    void notifyTo(String user, String message, NotificationType type);
}
