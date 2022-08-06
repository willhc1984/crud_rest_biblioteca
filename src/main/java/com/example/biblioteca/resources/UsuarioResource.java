package com.example.biblioteca.resources;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.model.dto.UsuarioDTO;
import com.example.biblioteca.model.dto.UsuarioSalvarDTO;
import com.example.biblioteca.repositories.UsuarioRepository;
import com.example.biblioteca.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> buscarTodos(){
		List<UsuarioDTO> usuarios =  service.buscarTodos();
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> buscarPoId(@PathVariable Integer id) {
		UsuarioDTO usuario = service.buscarPoId(id);
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioSalvarDTO dto) {
		/*
		 * usuario = usuarioRepository.findbyEmail(usuario.getEmail()); if(usuario !=
		 * null) { return ResponseEntity.unprocessableEntity().build(); }
		 */
		UsuarioDTO newDto = service.salvar(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newDto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(newDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> apagar(@PathVariable Integer id){
		service.apagar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Integer id, @RequestBody Usuario usuario){
		usuario = service.atualizar(id, usuario);
		return ResponseEntity.ok().body(usuario);
	}

}
