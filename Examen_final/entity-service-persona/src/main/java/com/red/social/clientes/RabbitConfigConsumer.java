package com.red.social.clientes;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfigConsumer {

    public final static String QUEUE_PERSONAS_ALTA = "queue-personas-alta";


    @Bean
    Queue queue() {
        return new Queue(QUEUE_PERSONAS_ALTA);
    }


    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange-principal");
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(QUEUE_PERSONAS_ALTA);
    }


}
