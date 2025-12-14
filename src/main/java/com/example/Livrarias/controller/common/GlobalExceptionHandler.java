package com.example.Livrarias.controller.common;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Livrarias.controller.dto.ErroCampo;
import com.example.Livrarias.controller.dto.ErroResposta;
import com.example.Livrarias.exceptions.RegistroDuplicadoException;
import com.example.Livrarias.exceptions.operaçaoNaoPermitida;

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

	// aula103
	@ExceptionHandler(RegistroDuplicadoException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErroResposta handleRegistroDuplicadoException(RegistroDuplicadoException e) {
		return ErroResposta.conflito(e.getMessage());
			}
	
	@ExceptionHandler(operaçaoNaoPermitida.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErroResposta handleoperaçaoNaoPermitida(operaçaoNaoPermitida e) {
		return ErroResposta.respostaPadrao(e.getMessage());
	}
	
	@ExceptionHandler (RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErroResposta handleErrosNaoTratados(RuntimeException e) {
		return new ErroResposta( HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Ocorreu um erro inesperado. Entre em contato com o adm."
				,List.of());
	}
	
	
	
}
