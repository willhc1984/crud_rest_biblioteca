package com.example.biblioteca.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UsuarioSalvarDTO extends UsuarioDTO{
	
	@NotBlank(message = "Senha não deve estar em branco.")
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$", message = "Senha deve conter uma letra maiuscula, uma minuscula, um numero e ter entre 4 a 8 digitos.")
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
