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
		
		Usuario u1 = new Usuario(null, "José", "1576543425", "jose@gmail.com", "123");
		Usuario u2 = new Usuario(null, "Maria", "1567890987", "mariae@gmail.com", "123");
		Usuario u3 = new Usuario(null, "Marcos", "15887652098", "marcos@gmail.com", "123");
		Usuario u4 = new Usuario(null, "Ana Paula", "15998763651", "anapaula@gmail.com", "123");		
		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		
		Emprestimo ep1 = new Emprestimo(null, new Date(), new Date());
		Emprestimo ep2 = new Emprestimo(null, new Date(), new Date());
		Emprestimo ep3 = new Emprestimo(null, new Date(), new Date());
		Emprestimo ep4 = new Emprestimo(null, new Date(), new Date());		
		ep1.setUsuario(u4);
		ep2.setUsuario(u4);
		ep3.setUsuario(u3);
		ep4.setUsuario(u3);
		emprestimoRepository.saveAll(Arrays.asList(ep1, ep2, ep3, ep4));
		
		Livro l1 = new Livro(null, "Brave New World", 569, 5.15);
		Livro l2 = new Livro(null, "Harry Potter", 1234, 4.25);
		Livro l3 = new Livro(null, "Flashbacks", 987, 3.50);
		Livro l4 = new Livro(null, "1984", 765, 3.10);
		ep1.setLivro(l4);
		ep2.setLivro(l3);
		ep3.setLivro(l2);
		ep4.setLivro(l1);
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4));
		emprestimoRepository.saveAll(Arrays.asList(ep1, ep2, ep3, ep4));
		
		Genero g1 = new Genero(null, "Ficção");
		Genero g2 = new Genero(null, "Distopia");
		Genero g3 = new Genero(null, "Magia");
		Genero g4 = new Genero(null, "Infantil");
		l1.setGenero(g4);
		l2.setGenero(g3);
		l3.setGenero(g2);
		l4.setGenero(g1);
		generoRepository.saveAll(Arrays.asList(g1, g2, g3, g4));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4));
		
		Editora e1 = new Editora(null, "Fantasia");
		Editora e2 = new Editora(null, "Abril");
		Editora e3 = new Editora(null, "Globo");
		Editora e4 = new Editora(null, "Edipro");
		l1.setEditora(e4);
		l2.setEditora(e3);
		l3.setEditora(e2);
		l4.setEditora(e1);
		editoraRepository.saveAll(Arrays.asList(e1, e2, e3, e4));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4));
		
		Colecao c1 = new Colecao(null, "Classicos");
		Colecao c2 = new Colecao(null, "Classicos II");
		l1.setColecao(c2);
		l2.setColecao(c2);
		l3.setColecao(c1);
		l4.setColecao(c1);		
		colecaoRepository.saveAll(Arrays.asList(c1, c2));
		livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4));	
	}

}
