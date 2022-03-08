package com.example.demo.tarea1;

import com.example.demo.tarea1.message.EmailMessageServiceImpl;
import com.example.demo.tarea1.message.FacebookMessageServiceImpl;
import com.example.demo.tarea1.message.TwitterMessageServiceImpl;
import com.example.demo.tarea1.notification.INotificationService;
import com.example.demo.tarea1.notification.NotificationType;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotificationServiceTests {
    
    private static ApplicationContext applicationContext;

	@BeforeClass
    public static void beforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("spring/tarea1/beans.xml");
    }

    @Test
    public void notificationServiceTest() {
        log.info("Testing notification service...");

        INotificationService notificationService = (INotificationService) applicationContext
                .getBean("notificationServiceBean");
        
        notificationService.notifyTo("oga", "saludo", NotificationType.FACEBOOK);

        Assert.assertEquals(FacebookMessageServiceImpl.class,
                notificationService.getFacebookMessageService().getClass());
        Assert.assertEquals(TwitterMessageServiceImpl.class,
                notificationService.getTwitterMessageService().getClass());
        Assert.assertEquals(EmailMessageServiceImpl.class,
                notificationService.getEmailMessageService().getClass());
                
    }

}
