package com.github.nielsonrocha.eventsender.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.Queue;

import com.github.nielsonrocha.eventsender.domain.Mensagem;


@Service
public class MessageSenderService {
	
	private static final Logger log = LoggerFactory.getLogger(MessageSenderService.class);
	 
    private final RabbitTemplate rabbitTemplate;
    
    @Autowired
    private Queue queue;
    
    @Autowired
    public MessageSenderService(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
    public void sendMessage(Mensagem mensagem) {
        log.info("Enviando mensagem...");
        rabbitTemplate.convertAndSend(this.queue.getName(), mensagem);
    }
}
