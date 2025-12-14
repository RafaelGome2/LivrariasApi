package com.example.Livrarias.mappers;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Livrarias.controller.dto.AutorDTO;
import com.example.Livrarias.model.autor.Autor;
@Mapper(componentModel = "spring")
@Primary
public interface AutorMapper {
  Autor toEntity(AutorDTO dto);
  
		 public AutorDTO toDTO(Autor autor); }
