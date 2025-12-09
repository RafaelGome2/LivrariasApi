package com.example.Livrarias.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Livrarias.dto.CadastroLivroDto;
import com.example.Livrarias.dto.ErroResposta;
import com.example.Livrarias.exceptions.RegistroDuplicadoException;
import com.example.Livrarias.service.LivroService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
// aula 98

@RestController
@RequestMapping("livros")
@RequiredArgsConstructor
public class LivroController {

	private final LivroService service;
	
	public LivroController(LivroService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Object> salvar(@RequestBody @Valid CadastroLivroDto dto){
		try {
	// mapeat dto para entidade
	// enviar a entidade para o serviço validar e salvar na base
// criar url para acesso dos dados do livro
// retornar codigo created com header location
			return ResponseEntity.ok(dto);
			
			
		} catch (RegistroDuplicadoException e) {
			var erroDTO = ErroResposta.conflito(e.getMessage());
			return ResponseEntity.status(erroDTO.status()).body(erroDTO);
			// TODO: handle exception
		}
		
	}

}
