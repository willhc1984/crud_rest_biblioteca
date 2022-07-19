package com.example.biblioteca;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repositories.EmprestimoRepository;
import com.example.biblioteca.repositories.LivroRepository;
import com.example.biblioteca.repositories.UsuarioRepository;

@SpringBootApplication
public class BibliotecaApplication implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "José", "1576543425", "jose@gmail.com");
		Usuario u2 = new Usuario(null, "Maria", "1567890987", "mariae@gmail.com");
		Usuario u3 = new Usuario(null, "Marcos", "15887652098", "marcos@gmail.com");
		Usuario u4 = new Usuario(null, "Ana Paula", "15998763651", "anapaula@gmail.com");		
		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		
		Emprestimo ep1 = new Emprestimo(null, new Date(), new Date());
		Emprestimo ep2 = new Emprestimo(null, new Date(), new Date());
		Emprestimo ep3 = new Emprestimo(null, new Date(), new Date());
		Emprestimo ep4 = new Emprestimo(null, new Date(), new Date());
		emprestimoRepository.saveAll(Arrays.asList(ep1, ep2, ep3, ep4));
		
		Livro l1 = new Livro(null, "Brave New World", 569, 5.15);
		Livro l2 = new Livro(null, "Harry Potter", 1234, 4.25);
		Livro l3 = new Livro(null, "Flashbacks", 987, 3.50);
		Livro l4 = new Livro(null, "1984", 765, 3.10);
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4));
		
		
		
		
	}

}
