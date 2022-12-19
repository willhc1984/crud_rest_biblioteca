package com.example.biblioteca.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.model.dto.UsuarioDTO;
import com.example.biblioteca.model.dto.UsuarioSalvarDTO;
import com.example.biblioteca.repositories.UsuarioRepository;
import com.example.biblioteca.services.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> buscarTodos() {
		List<UsuarioDTO> usuarios = service.buscarTodos();
		return ResponseEntity.ok(usuarios);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Integer id) {
		UsuarioDTO dto = service.buscarPorId(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<UsuarioDTO> salvar(@Valid @RequestBody UsuarioSalvarDTO dto) {		
		UsuarioDTO newDto = service.salvar(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDto.getId()).toUri();
		return ResponseEntity.created(uri).body(newDto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Integer id) {
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Integer id, @Valid @RequestBody UsuarioSalvarDTO dto) {
		UsuarioDTO newDto = service.atualizar(id, dto);
		return ResponseEntity.ok().body(newDto);
	}
	
	@GetMapping(value = "/buscarPorNome")
	public ResponseEntity<List<Usuario>> buscarPorNome(@RequestParam String nome){
		List<Usuario> usuarios = usuarioRepository.buscarPorNome(nome.trim().toUpperCase());
		return ResponseEntity.ok(usuarios);		
	}

}
