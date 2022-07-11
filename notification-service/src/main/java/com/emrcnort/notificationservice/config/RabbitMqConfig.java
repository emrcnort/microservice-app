package com.emrcnort.notificationservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Value("${queue.rabbitmq.exchange}")
    private String exchange;

    @Value("${queue.rabbitmq.name}")
    private String queueName;

    @Value("${queue.rabbitmq.routingKey}")
    private String routingKey;

    @Bean
    DirectExchange exchange(){ return new DirectExchange(exchange);}

    @Bean
    Queue notificationQueue(){ return new Queue(queueName);}

    @Bean
    Binding binding (Queue notificationQueue, DirectExchange exchange){
        return BindingBuilder.bind(notificationQueue).to(exchange).with(routingKey);
    }

    @Bean
    public MessageConverter jsonMessageConverter(){return new Jackson2JsonMessageConverter();
    }



}
