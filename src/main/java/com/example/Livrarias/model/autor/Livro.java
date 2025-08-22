package com.example.Livrarias.model.autor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Table (name = "livro", schema= "public")
@ToString (exclude = "autor")
public class Livro {
	public Livro() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", nullable = false)	
	private UUID id;
	
	@Column(name="isbn", length = 20, nullable= false )
	private String isbn;
	
	@Column(name= "titulo", length= 150, nullable = false)
	private String titulo;
	
	@Column(name = "data_publicaçao", nullable = false)
	private LocalDate dataPublicaçao;
	
	

	@Enumerated (EnumType.STRING)
	@Column(name= "genero", length=30, nullable= false)
	private LivroGenero genero;
	
	@Column(name="preço", precision = 18, scale=2 )
	private BigDecimal preço;
	
	@ManyToOne( fetch= FetchType.LAZY)
	@JoinColumn(name = "id_autor")    
	private Autor autor;

	
// ***** getters and setters ******
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDataPublicaçao() {
		return dataPublicaçao;
	}

	public void setDataPublicaçao(LocalDate dataPublicaçao) {
		this.dataPublicaçao = dataPublicaçao;
	}

	public LivroGenero getGenero() {
		return genero;
	}

	public void setGenero(LivroGenero genero) {
		this.genero = genero;
	}

	public BigDecimal getPreço() {
		return preço;
	}

	public void setPreço(BigDecimal preço) {
		this.preço = preço;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", dataPublicaçao=" + dataPublicaçao
				+ ", genero=" + genero + ", preço=" + preço + "]";
	}

	
  
	
}
