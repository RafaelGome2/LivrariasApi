package com.example.Livrarias.repository;


import static org.mockito.Mockito.mock;

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
import jakarta.persistence.FetchType;




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
	  		}	  }
  
    public void Delete() {
    	String uuidString = "2952424a-1940-4bcc-874a-358e0722a732" ;
    	UUID uuid= UUID.fromString(uuidString);
    		repository.deleteById(uuid);
     }
    
    public void Count() {
    	Long count= repository.count();
    	System.out.println("numero de altores= "+ count);
  }
    
  public void listarTest() {
  	List<Autor> lista = repository.findAll();
  	lista.forEach(System.out::println);
  	     }
    
 // aula 64-- salvar autor com livro(s)
 
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
    
// aula 65 -  sempre usar fetch= FetchType.LAZY (aula finalizada com sucesso!)
   // @Test
   void listarLivrosAutor() {
   var id =UUID.fromString("4f1b5629-af31-4e96-8107-17f8d95d1126") ;
   var autor =repository.findById(id).get();
   
    
  List<Livro> listasDLivros= livroRepository.findByAutor(autor);
     
  autor.setLivros(listasDLivros);		 
    autor.getLivros().forEach(System.out::println);
    /*for(Livro s :autor.getLivros()) {
    	System.out.println(s.getTitulo());
    	System.out.println(s.getId());*/
    }
   
    //aula 67
   void buscarPorNome() {
  	 List<Autor> lista = repository.findByNameContaining("Joao");
  	 List<Autor> lista2 = repository.findByNameContaining("joao");
  	 for(Autor a: lista) {
  		 System.out.println(a);
  	 }
  	 for(Autor a: lista2) {
  		 System.out.println(a);
  	 }
   }
 // aula 68
   @Test
  void listarPorNascimento() 
  {  List<Autor> lista = repository.listarPorNascimento();
  	lista.forEach(System.out::println);  
  }
  	
    }     
  
	
  
