package com.example.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.model.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Integer>{

}
