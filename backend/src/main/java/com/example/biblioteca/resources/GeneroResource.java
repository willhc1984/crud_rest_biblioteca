package com.example.biblioteca.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

import com.example.biblioteca.model.Editora;
import com.example.biblioteca.model.Genero;
import com.example.biblioteca.model.dto.GeneroDTO;
import com.example.biblioteca.services.GeneroService;

@RestController
@RequestMapping(value = "/generos")
public class GeneroResource {
	
	@Autowired
	private GeneroService service;
	
	@GetMapping
	public ResponseEntity<List<Genero>> buscarTodos(){
		return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> buscarPoId(@PathVariable Integer id) {
		Optional<Genero> generoOptional = service.buscarPoId(id);
		if(!generoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Genero não encontrado!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(service.buscarPoId(id));
	}
	
	@PostMapping
	public ResponseEntity<Genero> salvar(@RequestBody @Valid GeneroDTO generoDTO) {
		var genero = new Genero();
		BeanUtils.copyProperties(generoDTO, genero);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(genero));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> apagar(@PathVariable Integer id){
		Optional<Genero> generoOptional = service.buscarPoId(id);
		if(!generoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Genero não encontrado!");
		}
		service.apagar(generoOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body(generoOptional.get());
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Genero> atualizar(@PathVariable Integer id, @RequestBody Genero genero){
		genero = service.atualizar(id, genero);
		return ResponseEntity.ok().body(genero);
	}

}
