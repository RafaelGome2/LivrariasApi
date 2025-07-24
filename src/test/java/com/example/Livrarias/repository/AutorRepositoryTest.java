package com.example.Livrarias.repository;

import com.example.Livrarias.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class AutorRepositoryTest {

    private final AutorRepository repository;

    public AutorRepositoryTest(@Autowired AutorRepository repository) {
        this.repository = repository;
    }

    @Test
    public void salvarTest() {
        Autor autor = new Autor();
        autor.setName("Maria");
        autor.setDataNascimento(LocalDate.of(1990, 1, 2));
        autor.setNascionalidade("Brasileira");

        var autorSalvo = repository.save(autor);
        System.out.println("Autor salvo: " + autorSalvo);

    }
}
