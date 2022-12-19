package com.example.biblioteca.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.biblioteca.model.Usuario;

public class UsuarioDTO {
	
	private Integer id;
	@NotBlank(message = "Valor não pode ser nulo ou vazio.")
	private String nome;
	@Size(min = 8, max = 16, message = "Campo deve ter entre 9 e 16 caracteres")
	private String telefone;
	@Email(message = "Campos de email inválido.")
	private String email;
	
	public UsuarioDTO() {
	}
	
	public UsuarioDTO(Integer id, String nome, String telefone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.telefone = usuario.getTelefone();
		this.email = usuario.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
