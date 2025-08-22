package com.example.Livrarias.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.CompareTo;
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

		Autor autor = autorrepository.findById(UUID.fromString("cf52531f-c432-4289-b0d1-671ef7ffb3c7")).orElse(null);
		livro.setAutor(autor);
		repository.save(livro);
	}

	void listarListarLivros() {
		List<Livro> listaLivro = repository.findAll();
		listaLivro.forEach((Livro) -> System.out.println(Livro));
	}
//aula 62 - atualizando autor de um livro

	void atualizarAutorDoLivro() {
		Livro livroPatualizar = repository.findById(UUID.fromString("0d61c918-ae44-4df2-a785-c02b863d2f3c")).orElse(null);
		Autor Maria = autorrepository.findById(UUID.fromString("ed016c4b-ff0f-40f8-abca-2c843a00e1c7")).orElse(null);// se
																																																									// nao
																																																									// tiver
																																																									// este
																																																									// Id
																																																									// retorna
																																																									// null.

		livroPatualizar.setAutor(Maria);
		repository.save(livroPatualizar);
	}

	// ** aula 63-
	void buscarLivro() {
		Livro livro = repository.findById(UUID.fromString("0d61c918-ae44-4df2-a785-c02b863d2f3c")).orElse(null);
		System.out.print("Titulo: " + livro.getTitulo() + "  ");
		System.out.println("Autor: " + livro.getAutor().getName());
	}


	// aula 67
	void pesquisaUsandoContaining() {
		String a = "branca"; 
		List<Livro> lista = repository.findByTituloContaining(a.toLowerCase());
		System.out.println("tamanho da lista:" + lista.size());
			for(Livro l: lista) { System.out.println(l); }
	 }

	void buscarPorTitulo() {
		List<Livro> lista = repository.findByTitulo("");
		System.out.println("tamanho da lista:" + lista.size());
	}
	
	void listarTdsPorTitulo() {
		List<Livro> lista = repository.listarTdsOrdenadoPorTitulo();
	lista.forEach(System.out::println);
	}
	
// aula 69
@Test
void ordernarPor() {
	var lista= repository.OrdenarPor();
	lista.forEach(System.out::println);
}
	

}
