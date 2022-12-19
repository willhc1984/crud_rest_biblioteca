package com.example.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.Colecao;
import com.example.biblioteca.repositories.ColecaoRepository;

@Service
public class ColecaoService {

	@Autowired
	private ColecaoRepository repository;
	
	public List<Colecao> buscarTodos(){
		List<Colecao> colecaos = repository.findAll();
		return colecaos;
	}
	
	public Colecao buscarPoId(Integer id) {
		Optional<Colecao> colecao = repository.findById(id);
		return colecao.get();
	}
	
	public Colecao salvar(Colecao colecao) {
		return repository.save(colecao);
	}
	
	public void apagar(Integer id) {
		repository.deleteById(id);
	}
	
	public Colecao atualizar(Integer id, Colecao colecao) {
		Colecao obj = repository.getOne(id);
		updateData(obj, colecao);
		return repository.save(obj);
	}

	private void updateData(Colecao obj, Colecao colecao) {
		obj.setNome(colecao.getNome());
	}
	
}
