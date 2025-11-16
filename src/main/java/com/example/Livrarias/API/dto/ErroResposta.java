package com.example.Livrarias.API.dto;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

public record ErroResposta(Integer status, String mensagem, List<ErroCampo> listErros) {
 

	public static ErroResposta respostaPadrao(String mensagem) {
		return new ErroResposta(HttpStatus.BAD_REQUEST.value(), mensagem, List.of());
	}
	public static ErroResposta conflito(String mensagem) {
		return new ErroResposta(HttpStatus.CONFLICT.value(), mensagem, List.of());
	}
	
	
}
