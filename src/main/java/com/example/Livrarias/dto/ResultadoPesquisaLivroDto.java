package com.example.Livrarias.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.example.Livrarias.model.autor.LivroGenero;

public record ResultadoPesquisaLivroDto(
		UUID id,
		String isbn,
		String titulo,
		LocalDate dataPublicaçao,
		LivroGenero genero,
		BigDecimal preço,
		AutorDTO autor
) {

}
