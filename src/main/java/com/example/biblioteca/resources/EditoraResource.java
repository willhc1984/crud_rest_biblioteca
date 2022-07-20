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

import com.example.biblioteca.model.Editora;
import com.example.biblioteca.services.EditoraService;

@RestController
@RequestMapping(value = "/editoras")
public class EditoraResource {
	
	@Autowired
	private EditoraService service;
	
	@GetMapping
	public List<Editora> buscarTodos(){
		return service.buscarTodos();
	}
	
	@GetMapping(value = "/{id}")
	public Editora buscarPoId(@PathVariable Integer id) {
		return service.buscarPoId(id);
	}
	
	@PostMapping
	public Editora salvar(@RequestBody Editora editora) {
		return service.salvar(editora);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Integer id){
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Editora> atualizar(@PathVariable Integer id, @RequestBody Editora editora){
		editora = service.atualizar(id, editora);
		return ResponseEntity.ok().body(editora);
	}

}
