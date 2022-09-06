package com.example.biblioteca.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.dto.EmprestimoDTO;
import com.example.biblioteca.services.EmprestimoService;

@RestController
@RequestMapping(value = "/emprestimos")
public class EmprestimoResource {
	
	@Autowired
	private EmprestimoService service;
	
	@GetMapping
	public List<Emprestimo> buscarTodos(){
		List<Emprestimo> emprestimos =  service.buscarTodos();
		return emprestimos;
	}
	
	@GetMapping(value = "/{id}")
	public Emprestimo buscarPorId(@PathVariable Integer id) {
		return service.buscarPorId(id);
	}
	
	@PostMapping
	public Emprestimo salvar(@RequestBody Emprestimo emprestimo) {
		return service.salvar(emprestimo);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Integer id){
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Emprestimo> atualizar(@RequestBody Emprestimo emprestimo, @PathVariable Integer id){
		emprestimo = service.atualizar(id, emprestimo);
		return ResponseEntity.ok().body(emprestimo);
	}

}
