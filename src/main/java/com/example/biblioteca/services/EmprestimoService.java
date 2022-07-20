package com.example.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.repositories.EmprestimoRepository;

@Service
public class EmprestimoService {
	
	@Autowired
	private EmprestimoRepository repository;
	
	public List<Emprestimo> buscarTodos(){
		List<Emprestimo> emprestimos = repository.findAll();
		return emprestimos;
	}
	
	public Emprestimo buscarPorId(Integer id) {
		Optional<Emprestimo> emprestimo = repository.findById(id);
		return emprestimo.get();
	}
	
	public Emprestimo salvar(Emprestimo emprestimo) {
		return repository.save(emprestimo);
	}
	
	public void apagar(Integer id) {
		repository.deleteById(id);
	}
	
	public Emprestimo atualizar(Integer id, Emprestimo emprestimo) {
		Emprestimo obj = repository.getOne(id);
		updateData(obj, emprestimo);
		return repository.save(obj);
	}

	private void updateData(Emprestimo obj, Emprestimo emprestimo) {
		obj.setDataDevolucao(emprestimo.getDataDevolucao());
		obj.setDataEmprestimo(emprestimo.getDataEmprestimo());
	}

}
