package com.example.Livrarias.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.validator.constraints.ISBN;

import com.example.Livrarias.model.autor.LivroGenero;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

//aula 97, 98
public record CadastroLivroDto(
		@NotBlank(message ="campo obrigatorio")
		@ISBN
		String isbn,
		@NotBlank(message ="campo obrigatorio")
		String titulo,
		@NotNull(message ="campo obrigatorio")
		@Past(message ="não pode ser uma data futura")
		LocalDate dataPublicaçao,
		LivroGenero genero,
		BigDecimal preço,
		@NotNull(message ="campo obrigatorio")
		UUID idAutor
		) {

}
