package com.example.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repositories.UsuarioRepository;
import com.example.campeonato.model.Campeonato;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> buscarTodos(){
		List<Usuario> usuarios = repository.findAll();
		return usuarios;
	}
	
	public Usuario buscarPoId(Integer id) {
		Optional<Usuario> usuario = repository.findById(id);
		return usuario.get();
	}
	
	public Usuario salvar(Usuario usuario) {
		return repository.save(usuario);
	}
	
	public void apagar(Integer id) {
		repository.deleteById(id);
	}
	
	public Usuario atualizar(Integer id, Usuario usuario) {
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
