package com.example.biblioteca;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.biblioteca.model.Colecao;
import com.example.biblioteca.model.Editora;
import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Genero;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Usuario;
import com.example.biblioteca.repositories.ColecaoRepository;
import com.example.biblioteca.repositories.EditoraRepository;
import com.example.biblioteca.repositories.EmprestimoRepository;
import com.example.biblioteca.repositories.GeneroRepository;
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
	
	@Autowired
	private GeneroRepository generoRepository;
	
	@Autowired
	private EditoraRepository editoraRepository;
	
	@Autowired
	private ColecaoRepository colecaoRepository;

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
		
		Genero g1 = new Genero(null, "Ficção");
		Genero g2 = new Genero(null, "Distopia");
		Genero g3 = new Genero(null, "Magia");
		Genero g4 = new Genero(null, "Infantil");
		generoRepository.saveAll(Arrays.asList(g1, g2, g3, g4));
		
		Editora e1 = new Editora(null, "Fantasia");
		Editora e2 = new Editora(null, "Abril");
		Editora e3 = new Editora(null, "Globo");
		Editora e4 = new Editora(null, "Edipro");
		editoraRepository.saveAll(Arrays.asList(e1, e2, e3, e4));
		
		Colecao c1 = new Colecao(null, "Classicos");
		Colecao c2 = new Colecao(null, "Classicos II");
		colecaoRepository.saveAll(Arrays.asList(c1, c2));
		
		
	}

}
