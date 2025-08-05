package com.example.Livrarias.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Livrarias.model.autor.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, UUID>{

}
