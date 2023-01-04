package com.example.biblioteca.resources;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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

import com.example.biblioteca.model.Editora;
import com.example.biblioteca.model.dto.EditoraDTO;
import com.example.biblioteca.services.EditoraService;

@RestController
@RequestMapping(value = "/editoras")
public class EditoraResource {
	
	@Autowired
	private EditoraService service;
	
	@GetMapping
	public ResponseEntity<List<Editora>> buscarTodos(){
		return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> buscarPoId(@PathVariable Integer id) {
		Optional<Editora> editoraOptional = service.buscarPorId(id);
		if(!editoraOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Editora não encontrada!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(editoraOptional.get());
	}
	
	@PostMapping
	public ResponseEntity<Object> salvar(@RequestBody @Valid EditoraDTO editoraDTO) {
		var editora = new Editora();
		BeanUtils.copyProperties(editoraDTO, editora);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(editora));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> apagar(@PathVariable Integer id){
		Optional<Editora> editoraOptional = service.buscarPorId(id);
		if(!editoraOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Editora não encontrada!");
		}
		service.apagar(editoraOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Editora excluida!");
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Editora> atualizar(@PathVariable Integer id, @RequestBody Editora editora){
		editora = service.atualizar(id, editora);
		return ResponseEntity.ok().body(editora);
	}

}
