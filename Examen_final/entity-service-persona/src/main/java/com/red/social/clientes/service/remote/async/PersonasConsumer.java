package com.red.social.clientes.service.remote.async;

import com.red.social.clientes.RabbitConfigConsumer;
import com.red.social.clientes.modelo.PersonasDto;
import com.red.social.clientes.service.PersonaServiceImpl;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
    public class PersonasConsumer {

        public static final Logger logger = LoggerFactory.getLogger(PersonasConsumer.class);
        private Gson json = new Gson();
        private PersonaServiceImpl personasServiceImpl;

        public PersonasConsumer(PersonaServiceImpl personasServiceImpl) {
            this.personasServiceImpl = personasServiceImpl;
        }

        @RabbitListener(queues = RabbitConfigConsumer.QUEUE_PERSONAS_ALTA)
        public void listenAlta(Message message) {
            String body = new String(message.getBody());
            logger.info("Event alta" + body);
            PersonasDto personas = json.fromJson(body,PersonasDto.class);
            personasServiceImpl.modificar("f50d562d-bc67-4471-85a1-809024a21273",personas);
        }
    }

