package com.github.nielsonrocha.eventsender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.nielsonrocha.eventsender.domain.Mensagem;
import com.github.nielsonrocha.eventsender.service.MessageSenderService;

@RestController()
public class SendController {
	
	@Autowired
	private MessageSenderService messageSenderService;

	@RequestMapping("/send")
    public String greeting(@RequestParam(value="titulo", defaultValue="Olá") String titulo, @RequestParam(value="descricao", defaultValue="Mundo") String descricao) {
        Mensagem mensagem = new Mensagem(titulo, descricao);
		messageSenderService.sendMessage(mensagem);
		return "Mensagem enviada";
    }
}
