package com.github.nielsonrocha.eventsender.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mensagem implements Serializable {

	private static final long serialVersionUID = 1L;

	private String titulo;
	
	private String descricao;
	
}
