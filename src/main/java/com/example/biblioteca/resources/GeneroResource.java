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

import com.example.biblioteca.model.Genero;
import com.example.biblioteca.services.GeneroService;

@RestController
@RequestMapping(value = "/generos")
public class GeneroResource {
	
	@Autowired
	private GeneroService service;
	
	@GetMapping
	public List<Genero> buscarTodos(){
		return service.buscarTodos();
	}
	
	@GetMapping(value = "/{id}")
	public Genero buscarPoId(@PathVariable Integer id) {
		return service.buscarPoId(id);
	}
	
	@PostMapping
	public Genero salvar(@RequestBody Genero genero) {
		return service.salvar(genero);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Integer id){
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Genero> atualizar(@PathVariable Integer id, @RequestBody Genero genero){
		genero = service.atualizar(id, genero);
		return ResponseEntity.ok().body(genero);
	}

}
