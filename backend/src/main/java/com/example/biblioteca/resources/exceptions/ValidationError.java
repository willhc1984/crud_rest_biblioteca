package com.example.biblioteca.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class ValidationError implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String titulo = "Erro de validação";
	private String campo;
	private String mensagem;

	public ValidationError() {
	}
	
	public ValidationError(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	

	

}
