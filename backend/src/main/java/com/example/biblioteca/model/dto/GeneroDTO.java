package com.example.biblioteca.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class GeneroDTO {
	
	private Long id;
	@NotBlank
	@Size(min = 3, max = 40)
	private String descricao;
	
	public GeneroDTO(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
