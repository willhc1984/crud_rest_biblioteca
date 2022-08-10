package com.example.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.model.dto.UsuarioDTO;
import com.example.biblioteca.model.dto.UsuarioSalvarDTO;
import com.example.biblioteca.repositories.UsuarioRepository;
import com.example.biblioteca.services.exceptions.DataBaseException;
import com.example.biblioteca.services.exceptions.EntityNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public List<UsuarioDTO> buscarTodos() {
		List<Usuario> usuarios = repository.findAll();
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		for (Usuario u : usuarios) {
			UsuarioDTO usuarioDTO = new UsuarioDTO(u);
			usuariosDTO.add(usuarioDTO);
		}
		return usuariosDTO;
	}

	public UsuarioDTO buscarPorId(Integer id) {
		Usuario usuario = repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Id não encontrado - " + id));
		UsuarioDTO dto = new UsuarioDTO(usuario);
		return dto;
	}

	public UsuarioDTO salvar(UsuarioSalvarDTO dto) {
		Usuario entity = new Usuario();
		copyToEntity(dto, entity);
		entity.setPassword(dto.getPassword());
		try {
			repository.save(entity);
			return new UsuarioDTO(entity);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Email ja existe");
		}
	}

	private void copyToEntity(UsuarioDTO dto, Usuario entity) {
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setTelefone(dto.getTelefone());
	}

	public void apagar(Integer id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException("Id não encontrado - " + id);
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			throw new DataBaseException("Usuario possui emprestimos");
		}
	}

	public UsuarioDTO atualizar(Integer id, UsuarioSalvarDTO dto) {
		try {
			Usuario obj = repository.getReferenceById(id);
			updateData(obj, dto);
			obj.setPassword(dto.getPassword());
			obj = repository.save(obj);
			return new UsuarioDTO(obj);
		} catch (Exception e) {
			throw new EntityNotFoundException("Id não encontrado - " + id);
		}
	}

	private void updateData(Usuario obj, UsuarioSalvarDTO dto) {
		obj.setNome(dto.getNome());
		obj.setEmail(dto.getEmail());
		obj.setTelefone(dto.getTelefone());
	}

}
