package com.example.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
