package com.example.Livrarias.repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.aspectj.apache.bcel.Repository;
import org.hibernate.internal.build.AllowSysOut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.Livrarias.model.autor.Autor;
import com.example.Livrarias.repository.AutorRepository;

import ch.qos.logback.core.net.SyslogOutputStream;




@SpringBootTest
 public class AutorRepositoryTest {

   private final AutorRepository repository;
	      public AutorRepositoryTest(@Autowired AutorRepository repository) {
           this.repository = repository;
       }

    
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
  
	/*
	 * public void deletePorObj() { var id= UUID.fromString();
	 */
  	
  
  
}
