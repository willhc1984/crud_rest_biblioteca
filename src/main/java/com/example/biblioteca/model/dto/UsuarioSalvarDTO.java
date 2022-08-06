package com.example.biblioteca.model.dto;

public class UsuarioSalvarDTO extends UsuarioDTO{
	
	private String password;
	
	public UsuarioSalvarDTO() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
