package com.example.biblioteca.services;

import java.util.List;
import java.util.Optional;

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
	
	public Genero buscarPoId(Integer id) {
		Optional<Genero> genero = repository.findById(id);
		return genero.get();
	}
	
	public Genero salvar(Genero genero) {
		return repository.save(genero);
	}
	
	public void apagar(Integer id) {
		repository.deleteById(id);
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
