package com.example.Livrarias.API.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.example.Livrarias.model.autor.Autor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class AutorDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", nullable = false )
	private UUID id;
	@NotBlank(message ="campo obrigatorio")
	private String name;
	@NotNull(message ="campo obrigatorio")
	private LocalDate dataNascimento;
	@NotBlank(message ="campo obrigatorio")
	private String nascionalidade;
	;
	
	@Override
	public String toString() {
		return "AutorDTO [name=" + name + ", dataNascimento=" + dataNascimento + ", nascionalidade=" + nascionalidade + "]";
	}

// **** construtor ***
	
	  public AutorDTO(UUID id, String name, LocalDate dataNascimento, String nascionalidade) { 
	  this.id = id; 
	  this.name = name; 
	  this.dataNascimento =	  dataNascimento; 
	  this.nascionalidade = nascionalidade; }
	 

	public Autor mapearParaAutor() {
		 Autor autor = new Autor();
		 autor.setName(this.name);
		 autor.setDataNascimento(this.dataNascimento);
		 autor.setNascionalidade(this.nascionalidade);
		 
		return autor;
	}

	
	// ***
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNascionalidade() {
		return nascionalidade;
	}
	public void setNascionalidade(String nascionalidade) {
		this.nascionalidade = nascionalidade;
	}



}
