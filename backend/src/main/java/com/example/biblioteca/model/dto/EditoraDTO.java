package com.example.biblioteca.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class EditoraDTO {
	
	@NotBlank
	@Min(value = 3)
	private String nome;
	
	public EditoraDTO() {
	}

	public EditoraDTO(Long id, String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
