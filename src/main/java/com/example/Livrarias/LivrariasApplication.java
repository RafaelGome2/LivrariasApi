package com.example.Livrarias;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.Livrarias.model.autor.Autor;
import com.example.Livrarias.repository.AutorRepository;

@EnableJpaAuditing
@SpringBootApplication
public class LivrariasApplication {

	public static void main(String[] args) {
	SpringApplication.run(LivrariasApplication.class, args);
    
   
    }

	}
	
	
