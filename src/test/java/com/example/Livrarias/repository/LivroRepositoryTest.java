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
	@Test
	void listarListarLivros() {
		List<Livro> listaLivro= repository.findAll();
		listaLivro.forEach((Livro)-> System.out.println(Livro));
					}
		
	}


