package com.example.biblioteca.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.Editora;
import com.example.biblioteca.repositories.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repository;
	
	public List<Editora> buscarTodos(){
		List<Editora> editoras = repository.findAll();
		return editoras;
	}
	
	public Optional<Editora> buscarPorId(Integer id) {
		return repository.findById(id);
	}
	
	public Editora salvar(Editora editora) {
		return repository.save(editora);
	}
	
	@Transactional
	public void apagar(Editora editora) {
		repository.delete(editora);
	}
	
	public Editora atualizar(Integer id, Editora editora) {
		Editora obj = repository.getOne(id);
		updateData(obj, editora);
		return repository.save(obj);
	}

	private void updateData(Editora obj, Editora editora) {
		obj.setNome(editora.getNome());
	}
	
}
