package com.example.Livrarias.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Livrarias.model.autor.Autor;
import com.example.Livrarias.model.autor.Livro;
import com.example.Livrarias.model.autor.LivroGenero;

import jakarta.transaction.Transactional;
@Repository
public interface LivroRepository extends JpaRepository<Livro, UUID> {
		
	//aula 65 
	//Query method - select*from livro where id_autor = id;
	List<Livro> findByAutor(Autor autor);
	
// aula 67
	List<Livro> findByTituloContaining(String titulo);
	List<Livro> findByTitulo(String titulo);
	
	//JPQL  -> Referencia as entidades e as propriedades
	//select l.*from livro as l order by l.titulo,
	@Query(" select l from Livro as l order by l.titulo")
	List<Livro> listarTdsOrdenadoPorTitulo();
	
// aula 69	
	@Query("select livro from Livro livro order by livro.preço")
	 List<Livro> OrdenarPorPreço();
	
// aula 70 -- delete
	@Modifying
	@Transactional
	@Query ("delete from Livro where genero = ?1")
	void deleteByGenero(LivroGenero genero);
}
