package com.emrcnort.notificationservice.service;

import com.emrcnort.messaging.TicketNotification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationDurationService {

    @RabbitListener(queues = "${queue.rabbitmq.name}")
    public void onNotification(TicketNotification ticketNotification){
        System.out.println("----------------------------------");
        System.out.println("Notification alındı kullanıcılara gönderiliyor");
        System.out.println("Notification -> "+ ticketNotification.toString());
    }
}
