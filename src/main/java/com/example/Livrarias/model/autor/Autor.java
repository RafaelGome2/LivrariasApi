package com.example.Livrarias.model.autor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name ="autor" , schema = "public")
@Getter
@Setter

public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", nullable = false )
	private UUID id;
	
	 
	@Column (name ="name" , nullable = false, length = 100)
	private String name;
	
	@Column (name ="data_nascimento", nullable = false )
	private LocalDate dataNascimento;
	
	@Column (name= "nascionalidade",  nullable= false, length =50)
	private String nascionalidade;
	
	@OneToMany (mappedBy = "autor")@ToString.Exclude
	private List<Livro> livros;
	
	
	 public Autor() {
     // TODO Auto-generated constructor stub
 }
	
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
	

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id.toString() + ", name=" + name + ", dataNascimento=" + dataNascimento + ", nascionalidade="
				+ nascionalidade + "]";
	}
	
}
