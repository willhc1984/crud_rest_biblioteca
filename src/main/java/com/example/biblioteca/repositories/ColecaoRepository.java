package com.example.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColecaoRepository extends JpaRepository<ColecaoRepository, Integer>{

}
