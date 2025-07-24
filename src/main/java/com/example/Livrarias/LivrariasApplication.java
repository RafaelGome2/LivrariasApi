package com.example.Livrarias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivrariasApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(LivrariasApplication.class, args);
//        AutorRepository repository = context.getBean(AutorRepository.class);
//        salvarRegistro(repository);

    }
}