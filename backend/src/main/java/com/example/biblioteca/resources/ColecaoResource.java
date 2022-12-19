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

import com.example.biblioteca.model.Colecao;
import com.example.biblioteca.services.ColecaoService;

@RestController
@RequestMapping(value = "/colecoes")
public class ColecaoResource {
	
	@Autowired
	private ColecaoService service;
	
	@GetMapping
	public List<Colecao> buscarTodos(){
		return service.buscarTodos();
	}
	
	@GetMapping(value = "/{id}")
	public Colecao buscarPoId(@PathVariable Integer id) {
		return service.buscarPoId(id);
	}
	
	@PostMapping
	public Colecao salvar(@RequestBody Colecao colecao) {
		return service.salvar(colecao);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Integer id){
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Colecao> atualizar(@PathVariable Integer id, @RequestBody Colecao colecao){
		colecao = service.atualizar(id, colecao);
		return ResponseEntity.ok().body(colecao);
	}

}
