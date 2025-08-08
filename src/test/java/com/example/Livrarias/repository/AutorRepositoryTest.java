package com.example.Livrarias.repository;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.aspectj.apache.bcel.Repository;
import org.hibernate.internal.build.AllowSysOut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.Livrarias.model.autor.Autor;
import com.example.Livrarias.model.autor.Livro;
import com.example.Livrarias.model.autor.LivroGenero;
import com.example.Livrarias.repository.AutorRepository;

import ch.qos.logback.core.net.SyslogOutputStream;




@SpringBootTest
 public class AutorRepositoryTest {

   private final AutorRepository repository;
	      public AutorRepositoryTest(@Autowired AutorRepository repository) {
           this.repository = repository;
       }

	 @Autowired
	 LivroRepository livroRepository;
	     
    
	  public void salvarTest() {
		Autor autor = new Autor();
		autor.setName("Alex");
		autor.setDataNascimento(LocalDate.of(1980, 6, 13));
		autor.setNascionalidade("Argentino");
		
		var autorSalvo = repository.save(autor);
			}
	  
	  public void atualizarTest() {
	  	var id = UUID.fromString(null);
	  	Optional<Autor> possivelAutor=  repository.findById(null);
	  	if(possivelAutor.isPresent()) {
	  		System.out.println("Dados do autor: ");
	  		System.out.println(possivelAutor.get());
	  		
	  		
	  	}
	  	
	  }
  
    public void Delete() {
    	String uuidString = "2952424a-1940-4bcc-874a-358e0722a732" ;
    	UUID uuid= UUID.fromString(uuidString);
    		repository.deleteById(uuid);
 
    }
    
    public void Count() {
    	Long count= repository.count();
    	System.out.println("numero de altores= "+ count);
  }
    @Test 
  public void listarTest() {
  	List<Autor> lista = repository.findAll();
  	lista.forEach(System.out::println);
  	     }
    
 // aula 64
    @Test 
      void salvarAutorCLivros() {
      	Autor autor = new Autor();
    		autor.setName("Antonio");
    		autor.setDataNascimento(LocalDate.of(1950, 6, 1));
    		autor.setNascionalidade("Americano");
    			
    		Livro livro = new Livro();
    		livro.setIsbn("212187-658");
    		livro.setDataPublicaçao(LocalDate.of(2000, 12, 1));
    		livro.setGenero(LivroGenero.ROMANCE);
    		livro.setPreço(BigDecimal.valueOf(199));
    		livro.setTitulo("O melhor amigo do homem");
    		livro.setAutor(autor);
    		
    		Livro livro2 = new Livro();
    		livro2.setIsbn("212187-7896");
    		livro2.setDataPublicaçao(LocalDate.of(2001, 12, 1));
    		livro2.setGenero(LivroGenero.MISTERIO);
    		livro2.setPreço(BigDecimal.valueOf(99));
    		livro2.setTitulo("O roubo da casa branca");
    		livro2.setAutor(autor);
    		
    		autor.setLivros(new ArrayList<>());
    		autor.getLivros().add(livro);//pega lista "livros" e add objetos Livros a esta.
    		autor.getLivros().add(livro2);
    			
    		repository.save(autor);
    		livroRepository.saveAll(autor.getLivros());
    		}
      
  
	
  
}
