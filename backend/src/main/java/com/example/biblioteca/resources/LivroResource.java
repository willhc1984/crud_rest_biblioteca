package com.example.biblioteca.resources;

import java.time.Instant;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.resources.exceptions.StandardError;
import com.example.biblioteca.services.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService service;

	@GetMapping
	public List<Livro> buscarTodos() {
		return service.buscarTodos();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscarPoId(@PathVariable Integer id) {
		try {
			Livro livro = service.buscarPoId(id);
			return ResponseEntity.ok().body(livro);
		} catch (EntityNotFoundException e) {
			StandardError err = new StandardError();
			err.setTimestamp(Instant.now());
			err.setStatus(HttpStatus.NOT_FOUND.value());
			err.setError("Resource not found");
			err.setMessage(e.getMessage());
			err.setPath("test");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		}

	}

	@PostMapping
	public Livro salvar(@RequestBody Livro livro) {
		return service.salvar(livro);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Integer id) {
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> atualizar(@PathVariable Integer id, @RequestBody Livro livro) {
		livro = service.atualizar(id, livro);
		return ResponseEntity.ok().body(livro);
	}

}
