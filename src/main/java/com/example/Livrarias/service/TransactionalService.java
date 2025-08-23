package com.example.Livrarias.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Livrarias.model.autor.Autor;
import com.example.Livrarias.model.autor.Livro;
import com.example.Livrarias.model.autor.LivroGenero;
import com.example.Livrarias.repository.AutorRepository;
import com.example.Livrarias.repository.LivroRepository;

@Service
public class TransactionalService { 
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	
	@Transactional
	public void executar() {
		Autor autor = new Autor();
		autor.setName("Francisca Xiong Lee");
		autor.setDataNascimento(LocalDate.of(1920, 2, 10));
		autor.setNascionalidade("Chinesa");
		
		autorRepository.save(autor);
		
		Livro livro = new Livro();
		livro.setIsbn("4123-8862");
		livro.setDataPublicaçao(LocalDate.of(1945, 12, 1)); 
		livro.setGenero(LivroGenero.CIENCIA);
		livro.setPreço(BigDecimal.valueOf(235.00));
		livro.setTitulo("Sistemas operacionais: do basico ao avançado");
		livro.setAutor(autor);
		livroRepository.save(livro);
			}
	

}
