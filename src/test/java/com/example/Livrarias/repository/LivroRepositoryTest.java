package com.example.Livrarias.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Livrarias.model.autor.Autor;
import com.example.Livrarias.model.autor.Livro;
import com.example.Livrarias.model.autor.LivroGenero;
//******  aula 60 ******
@SpringBootTest
public class LivroRepositoryTest {
	
	@Autowired
	LivroRepository repository;
	@Autowired
	AutorRepository autorrepository;
	
	
	void salvarTest() {
		Livro livro = new Livro();
		livro.setIsbn("4198788965");
		livro.setDataPublicaçao(LocalDate.of(2025, 6, 12));
		livro.setGenero(LivroGenero.BIOGRAFIA);
		livro.setPreço(BigDecimal.valueOf(89.9));
		livro.setTitulo("A vida de Jesus Cristo");
		
		Autor autor = autorrepository.findById(UUID.fromString("cf52531f-c432-4289-b0d1-671ef7ffb3c7"))
				.orElse(null);		
		livro.setAutor(autor);
		repository.save(livro);
			}

	void listarListarLivros() {
		List<Livro> listaLivro= repository.findAll();
		listaLivro.forEach((Livro)-> System.out.println(Livro));
					}	
	//aula 62 - atualizando autor de um livro
	@Test
	 void atualizarAutorDoLivro() {
		 Livro livroPatualizar = repository.findById(UUID.fromString(
				 "0d61c918-ae44-4df2-a785-c02b863d2f3c"))
				 .orElse(null);
		 Autor Maria= autorrepository.findById(UUID
				 .fromString("ed016c4b-ff0f-40f8-abca-2c843a00e1c7"))
				 .orElse(null);//se nao tiver este Id retorna null.
		 
		 livroPatualizar.setAutor(Maria);
		 repository.save(livroPatualizar);
		 
	 }
	 
	}


