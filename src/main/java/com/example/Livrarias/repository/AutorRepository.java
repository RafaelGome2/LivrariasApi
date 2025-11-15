package com.example.Livrarias.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Livrarias.model.autor.Autor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface AutorRepository extends JpaRepository<Autor, UUID>{

	List<Autor> findByNameContaining(String name);
	
//JPQL  -> Referencia as entidades e as propriedades
	@Query("select a from Autor as a order by a.dataNascimento")
	List<Autor> listarPorNascimento();
	
	//** aula 85 - filtrar
	List<Autor> findByName(String name);
	List<Autor> findByNascionalidade(String nascionalidade);
	List<Autor> findByNameAndNascionalidade(String name, String nascionalidde);
// aula 89 14/11/2025
	Optional<Autor> findByNameAndDataNascimentoAndNascionalidade(
			String name, LocalDate dataNascimento, String nascionalidade);
	
	
}
