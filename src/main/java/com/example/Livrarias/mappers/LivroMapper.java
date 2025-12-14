package com.example.Livrarias.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Livrarias.controller.dto.CadastroLivroDto;
import com.example.Livrarias.model.autor.Livro;
import com.example.Livrarias.repository.AutorRepository;
//aula 101

@Mapper (componentModel = "spring")
@Component
public abstract class LivroMapper {
@Autowired
		AutorRepository autorRepository;

	@Mapping(target = "autor", expression = "java(autorRepository.findById(dto.idAutor()).orElse(null))")
	public abstract Livro toEntity(CadastroLivroDto dto);
	
	
}
