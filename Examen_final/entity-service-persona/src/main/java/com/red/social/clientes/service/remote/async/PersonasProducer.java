package com.red.social.clientes.service.remote.async;

import com.red.social.clientes.RabbitConfigConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


@Component
public class PersonasProducer {
    private RabbitTemplate rabbitTemplate;

    public static final Logger logger = LoggerFactory.getLogger(PersonasProducer.class);

    public PersonasProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String contractEvent) {
        rabbitTemplate.convertAndSend(RabbitConfigConsumer.QUEUE_PERSONAS_ALTA, contractEvent);
        logger.info(">>>Envio de alta..");
    }
}
