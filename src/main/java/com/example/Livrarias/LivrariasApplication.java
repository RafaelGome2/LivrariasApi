package com.example.Livrarias;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.Livrarias.model.autor.Autor;
import com.example.Livrarias.repository.AutorRepository;

@SpringBootApplication
public class LivrariasApplication {

	public static void main(String[] args) {
		 var context  = SpringApplication.run(LivrariasApplication.class, args);
    AutorRepository repository = context.getBean(AutorRepository.class);
   
    Stream<String> stream= 
    		Stream.of("Geeks", "for", "para", "lambda");
    	stream.forEach(s->System.out.println(s));
 }

	}
	
	
