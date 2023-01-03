package com.example.biblioteca.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class EditoraDTO {
	
	@NotBlank
	@Size(min = 3, max = 30)
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
