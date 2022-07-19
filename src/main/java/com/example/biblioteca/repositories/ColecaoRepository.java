package com.example.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.model.Colecao;

@Repository
public interface ColecaoRepository extends JpaRepository<Colecao, Integer>{

}
