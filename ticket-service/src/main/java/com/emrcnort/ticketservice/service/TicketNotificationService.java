package com.emrcnort.ticketservice.service;


import com.emrcnort.messaging.TicketNotification;
import com.emrcnort.ticketservice.entity.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketNotificationService {

    private final AmqpTemplate rabbitTemplate;

    @Value("${queue.rabbitmq.exchange}")
    private String exchange;

    @Value("${queue.rabbitmq.name}")
    private String queueName;

    @Value("${queue.rabbitmq.routingKey}")
    private String routingKey;

    void sendToQueue(Ticket ticket){
        TicketNotification ticketNotification = TicketNotification
                .builder()
                .ticketId(ticket.getId())
                .accountId(ticket.getAssignee())
                .ticketDescription(ticket.getDescription())
                .build();
        rabbitTemplate.convertAndSend(exchange, routingKey, ticketNotification);
    }
}