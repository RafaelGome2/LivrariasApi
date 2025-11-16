package com.example.Livrarias.controller.common;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Livrarias.API.dto.ErroCampo;
import com.example.Livrarias.API.dto.ErroResposta;

//aula 93 15/11/2025
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	 public ErroResposta handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
	List<FieldError> fieldErrors = e.getFieldErrors();
	List<ErroCampo> listaErros= fieldErrors.stream()
	.map(fe -> new ErroCampo(fe.getField(), fe.getDefaultMessage()) )
	.collect(Collectors.toList());
		return new ErroResposta( HttpStatus.UNPROCESSABLE_ENTITY.value(),"Erro de validação", listaErros );	 }

}
