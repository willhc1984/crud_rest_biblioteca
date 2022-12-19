package com.example.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer>{

}
