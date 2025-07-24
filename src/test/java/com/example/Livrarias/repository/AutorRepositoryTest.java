package com.example.Livrarias.repository;


import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.Livrarias.config.dataBaseConfiguration;
import com.example.Livrarias.model.autor.Autor;
import com.example.Livrarias.repository.AutorRepository;



@SpringBootTest(classes = dataBaseConfiguration.class)
 public class AutorRepositoryTest {

@Autowired
private AutorRepository repository;
	

 public AutorRepository getRepository() {
	return repository;
}
public void setRepository(AutorRepository repository) {
	this.repository = repository;
}


 @Test
	public void salvarTest() {
		Autor autor = new Autor();
		autor.setName("Maria");
		autor.setDataNascimento(LocalDate.of(1990, 1, 2));
		autor.setNascionalidade("Brasileira");
		
		var autorSalvo = repository.save(autor);
	System.out.println("Autor salvo: "+autorSalvo);
		
	}
}
