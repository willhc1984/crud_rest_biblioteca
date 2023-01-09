package com.example.biblioteca.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.Genero;
import com.example.biblioteca.repositories.GeneroRepository;

@Service
public class GeneroService {

	@Autowired
	private GeneroRepository repository;
	
	public List<Genero> buscarTodos(){
		List<Genero> generos = repository.findAll();
		return generos;
	}
	
	public Optional<Genero> buscarPoId(Integer id) {
		return repository.findById(id);
	}
	
	public Genero salvar(Genero genero) {
		return repository.save(genero);
	}
	
	@Transactional
	public void apagar(Genero genero) {
		repository.delete(genero);
	}
	
	public Genero atualizar(Integer id, Genero genero) {
		Genero obj = repository.getOne(id);
		updateData(obj, genero);
		return repository.save(obj);
	}

	private void updateData(Genero obj, Genero genero) {
		obj.setDescricao(genero.getDescricao());
	}
	
}
