package com.example.biblioteca.services;

import java.util.List;
import java.util.Optional;

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
	
	public Editora buscarPoId(Integer id) {
		Optional<Editora> editora = repository.findById(id);
		return editora.get();
	}
	
	public Editora salvar(Editora editora) {
		return repository.save(editora);
	}
	
	public void apagar(Integer id) {
		repository.deleteById(id);
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
