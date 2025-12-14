package com.example.Livrarias.controller;

import java.net.URI;
import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.tomcat.util.http.parser.HttpHeaderParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.Livrarias.controller.dto.AutorDTO;
import com.example.Livrarias.controller.dto.ErroResposta;
import com.example.Livrarias.data.Data;
import com.example.Livrarias.exceptions.RegistroDuplicadoException;
import com.example.Livrarias.exceptions.operaçaoNaoPermitida;
import com.example.Livrarias.model.autor.Autor;
import com.example.Livrarias.service.AutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.Livrarias.mappers.*;
//aula 79
@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
//http: //localhost:8080/autores
public class AutorController implements GenericControllers{

	private final AutorService service;
	private final AutorMapper mapper; //aula 99 7/12/2025

	//*** construtor 
	public AutorController(AutorService service, AutorMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

//aula 81
	@PostMapping
	public ResponseEntity<Object> salvar(@RequestBody @Valid AutorDTO  dto) {

		Autor autorEntidade= mapper.toEntity(dto);
		service.salvar(autorEntidade);
		// aula 102
   	URI location =	gerarHeaderLocation(autorEntidade.getId());
		return ResponseEntity.created(location).build();
		
	
		}		
		
	


	// aula 83- obtendo dados do autor, com GET
	@GetMapping("{id}")
	public ResponseEntity<AutorDTO> obterDetalhes(@PathVariable("id") String id){
		var idAutor= UUID.fromString(id);
			
		 return service
				 .ObterPorId(idAutor)
				 .map(autor -> {
					 AutorDTO dto = mapper.toDTO(autor);
					 return ResponseEntity.ok(dto);
				 }).orElseGet(()-> ResponseEntity.notFound().build());		
				 
			}
	
	
// aula 84 - deletar do banco de dados com HTTP
		@DeleteMapping("{id}")
		public ResponseEntity<Object> deletarAutor(@PathVariable("id") String id) {
			var idAutor = UUID.fromString(id);
			Optional<Autor> autorOptional = service.ObterPorId(idAutor);
			if (autorOptional.isEmpty()) {
				return ResponseEntity.notFound().build();
			}

			service.deletar(autorOptional.get());
			return ResponseEntity.noContent().build();

		}
		
		//retorna a concatenaçao de id + nome
		@GetMapping("/qual_id")
		public String getId(@RequestParam String id, @RequestParam String nome) {
			return ("https://pt.semrush.com/blog/parametros-url");
					}
		
		//**AULA 85 - FILTRAR
		@GetMapping
		public ResponseEntity<List<AutorDTO>> pesquisa(	@RequestParam (value="nome", required = false) 
		String name,
				@RequestParam(value= "nascionalidade", required = false) String nascionalidade){
			List<Autor> lista= service.pesquisaByExemple(name, nascionalidade);
			
			  List<AutorDTO> listDto = lista.stream().map(autor -> new AutorDTO(
			  autor.getId(), autor.getName(), autor.getDataNascimento(),
			  autor.getNascionalidade())).collect(Collectors.toList());
			  return ResponseEntity.ok(listDto);
			 			 	}
	// ** aula 86 -- atualizar autor
		@PutMapping("{id}")
		public ResponseEntity<Void>  atualizar(@PathVariable("id") String id, @RequestBody AutorDTO dto ){
			var idAutor = UUID.fromString(id);
			Optional<Autor> autorOptional =service.ObterPorId(idAutor);
			if(autorOptional.isEmpty()) {
				return ResponseEntity.notFound().build();}
			var autor= autorOptional.get();
			autor.setName(dto.getName());
			autor.setDataNascimento(dto.getDataNascimento());
			autor.setNascionalidade(dto.getNascionalidade());
			
			service.atualizar(autor);
			return ResponseEntity.noContent().build();
				}
		
		}

	
	






