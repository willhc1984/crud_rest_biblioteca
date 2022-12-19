package com.example.biblioteca.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	public List<Livro> buscarTodos(){
		List<Livro> livros = repository.findAll();
		return livros;
	}
	
	public Livro buscarPoId(Integer id) {
		Livro livro = repository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Id não encontrado " + id));
		return livro;
	}
	
	public Livro salvar(Livro livro) {
		return repository.save(livro);
	}
	
	public void apagar(Integer id) {
		repository.deleteById(id);
	}
	
	public Livro atualizar(Integer id, Livro livro) {
		Livro obj = repository.getOne(id);
		updateData(obj, livro);
		return repository.save(obj);
	}

	private void updateData(Livro obj, Livro livro) {
		obj.setTitulo(livro.getTitulo());
		obj.setPaginas(livro.getPaginas());
		obj.setValorDeMulta(livro.getValorDeMulta());
	}
	
}
