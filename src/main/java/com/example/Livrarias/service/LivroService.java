package com.example.Livrarias.service;

import org.springframework.stereotype.Service;

import com.example.Livrarias.model.autor.Livro;
import com.example.Livrarias.repository.LivroRepository;

import lombok.RequiredArgsConstructor;
@Service 
@RequiredArgsConstructor
public class LivroService {
	
	private final LivroRepository repository;

	public LivroService(LivroRepository repository) {
			this.repository = repository;
	}

	public Livro salvar(Livro livro) {
		return repository.save(livro);
		
		
	}


}
