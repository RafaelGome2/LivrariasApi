package com.example.Livrarias.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Service;

import com.example.Livrarias.exceptions.operaçaoNaoPermitida;
import com.example.Livrarias.model.autor.Autor;
import com.example.Livrarias.repository.AutorRepository;
import com.example.Livrarias.repository.LivroRepository;
import com.example.Livrarias.validator.AutorValidator;

@Service 
public class AutorService {
 private AutorRepository repository;
 private final AutorValidator validator; // aula 89- metodo para validar entrada de dados
 private final LivroRepository livroRepository;
 
 //*** constructor ****
 public AutorService(AutorRepository repository, AutorValidator validator, LivroRepository livroRepository) {
		this.validator = validator;
		this.repository = repository;
		this.livroRepository = livroRepository;
 }
 
 public Autor salvar(Autor autor) {
	 validator.validar(autor);
	 return repository.save(autor);
 }
 
 //** aula 86 
 public void atualizar(Autor autor) {
	 validator.validar(autor);
	if(autor.getId() == null) {
		throw new IllegalArgumentException(" p/ atualizar é necessario que autor esteja salvo na base");
			}
	repository.save(autor);
 }
 
 public Optional<Autor> ObterPorId(UUID id) {
	 return repository.findById(id);
 }
 // ** aula 84 **
 public void deletar(Autor autor){
	 if(possuiLivro(autor)) {
		 throw new operaçaoNaoPermitida("Não é permitido excluir um autor que possui livros cadastrados!");
		 
	 }
 repository.delete(autor);
 
 }  
 
 // ** aula 85 - filtrar
 public List<Autor> pesquisa(String name, String nascionalidade){
	 if(name != null && nascionalidade !=null) {
		 return repository.findByNameAndNascionalidade(name, nascionalidade);
		 	 }
	 if(name!=null) {
		 return repository.findByName(name);
		  }
	 if(nascionalidade != null) {
		 return repository.findByNascionalidade(nascionalidade);
		 	 }
	 return repository.findAll();
	  }
// aula 90 - 14/11/2025 
 public boolean possuiLivro(Autor autor) {
	 	 return livroRepository.existsByAutor(autor);
 }
 
 
}
