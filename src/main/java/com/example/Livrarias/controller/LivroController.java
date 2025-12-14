package com.example.Livrarias.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Livrarias.controller.dto.CadastroLivroDto;
import com.example.Livrarias.controller.dto.ErroResposta;
import com.example.Livrarias.exceptions.RegistroDuplicadoException;
import com.example.Livrarias.model.autor.Livro;
import com.example.Livrarias.service.LivroService;
import com.example.Livrarias.mappers.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
// aula 98

@RestController
@RequestMapping("livros")
@RequiredArgsConstructor
public class LivroController implements GenericControllers {

	private final LivroService service;
	private final LivroMapper livroMapper;

	public LivroController(LivroService service, LivroMapper livroMapper) {
		this.service = service;
		this.livroMapper = livroMapper;// aula 101
	}

	@PostMapping
	public ResponseEntity<Object> salvar(@RequestBody @Valid CadastroLivroDto dto) {
		Livro livro = livroMapper.toEntity(dto);
		service.salvar(livro);
		var url = gerarHeaderLocation(livro.getId());
		return ResponseEntity.created(url).build();

	}

}
