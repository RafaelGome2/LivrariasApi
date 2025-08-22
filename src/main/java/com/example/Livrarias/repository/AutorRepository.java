package com.example.Livrarias.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Livrarias.model.autor.Autor;
import java.util.List;


@Repository
public interface AutorRepository extends JpaRepository<Autor, UUID>{

	List<Autor> findByNameContaining(String name);
	
//JPQL  -> Referencia as entidades e as propriedades
	@Query("select a from Autor as a order by a.dataNascimento")
	List<Autor> listarPorNascimento();
	
}
