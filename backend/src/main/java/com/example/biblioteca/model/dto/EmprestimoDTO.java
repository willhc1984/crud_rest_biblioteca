package com.example.biblioteca.model.dto;

import java.util.Date;

import javax.validation.constraints.Past;

import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;

public class EmprestimoDTO {
	
	private Integer id;
	@Past(message = "Data invalida")
	private Date dataEmprestimo;
	@Past(message = "Data invalida")
	private Date dataDevolucao;
	private Usuario usuario;
	private Livro livro;
	
	public EmprestimoDTO() {
	}
	
	public EmprestimoDTO(Emprestimo emprestimo) {
		this.id = emprestimo.getId();
		this.dataEmprestimo = emprestimo.getDataEmprestimo();
		this.dataDevolucao = emprestimo.getDataDevolucao();
	}
	
	public EmprestimoDTO(Integer id, Date dataEmprestimo, Date dataDevolucao) {
		this.id = id;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}	

}
