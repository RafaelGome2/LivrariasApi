package com.example.Livrarias.controller.mappers;

import org.mapstruct.Mapper;

import com.example.Livrarias.dto.AutorDTO;
import com.example.Livrarias.model.autor.Autor;
// aula 99 -mapper
@Mapper(componentModel = "spring")
public interface AutorMapper {
	
	Autor toEntity(AutorDTO dto);
	
	AutorDTO toDTO(Autor autor);

}
