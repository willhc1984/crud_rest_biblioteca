package com.example.campeonato.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Livro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	private Integer paginas;
	private Double valorDeMulta;
	
	private Editora editora;
	private Genero genero;
	private List<Emprestimo> emprestimos = new ArrayList<>();
	private Colecao colecao;
	
	public Livro() {
	}

	public Livro(Integer id, String titulo, Integer paginas, Double valorDeMulta) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.paginas = paginas;
		this.valorDeMulta = valorDeMulta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public Double getValorDeMulta() {
		return valorDeMulta;
	}

	public void setValorDeMulta(Double valorDeMulta) {
		this.valorDeMulta = valorDeMulta;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public Colecao getColecao() {
		return colecao;
	}

	public void setColecao(Colecao colecao) {
		this.colecao = colecao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}

}
