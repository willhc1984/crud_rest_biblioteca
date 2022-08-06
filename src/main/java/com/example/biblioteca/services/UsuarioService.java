package com.example.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.model.dto.UsuarioDTO;
import com.example.biblioteca.model.dto.UsuarioSalvarDTO;
import com.example.biblioteca.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<UsuarioDTO> buscarTodos(){
		List<Usuario> usuarios = repository.findAll();
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		for(Usuario u : usuarios) {
			UsuarioDTO usuarioDTO = new UsuarioDTO(u);
			usuariosDTO.add(usuarioDTO);
		}
		return usuariosDTO;
	}
	
	public UsuarioDTO buscarPoId(Integer id) {
		Usuario usuario = repository.findById(id).get();
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		return usuarioDTO;
	}
	
	public UsuarioDTO salvar(UsuarioSalvarDTO dto) {
		Usuario entity = new Usuario();
		copyToEntity(dto, entity);
		entity.setPassword(dto.getPassword());
		entity = repository.save(entity);
		return new UsuarioDTO(entity);
	}
	
	private void copyToEntity(UsuarioDTO dto, Usuario entity) {
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setTelefone(dto.getTelefone());
	}

	public void apagar(Integer id) {
		repository.deleteById(id);
	}
	
	public Usuario atualizar(Integer id, Usuario usuario) {
		@SuppressWarnings("deprecation")
		Usuario obj = repository.getOne(id);
		updateData(obj, usuario);
		return repository.save(obj);
	}

	private void updateData(Usuario obj, Usuario usuario) {
		obj.setNome(usuario.getNome());
		obj.setEmail(usuario.getEmail());
		obj.setTelefone(usuario.getTelefone());
	}
	
}
