package com.example.Livrarias.validator;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.Livrarias.exceptions.RegistroDuplicadoException;
import com.example.Livrarias.model.autor.Autor;
import com.example.Livrarias.repository.AutorRepository;

@Component
public class AutorValidator {
 private AutorRepository repository;
 
//** constructor **
 public AutorValidator(AutorRepository repository) {
	this.repository = repository;
 }
 
 public void validar(Autor autor) {
	 if(existeAutorCadastrado(autor)) {
		 throw new RegistroDuplicadoException("autor já cadastrado!");
	 }
 }
 
 private boolean existeAutorCadastrado(Autor autor) {
	 Optional<Autor> autorEncontrado = repository.findByNameAndDataNascimentoAndNascionalidade(
			 autor.getName(), autor.getDataNascimento(), autor.getNascionalidade());
 if(autor.getId() ==null) {//caso o autor não esteja cadastrado
	 return autorEncontrado.isPresent();
 }
 return !autor.getId().equals(autorEncontrado.get().getId()) && autorEncontrado.isPresent();
	 
 };
}
