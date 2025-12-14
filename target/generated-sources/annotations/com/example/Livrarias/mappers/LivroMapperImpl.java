package com.example.Livrarias.mappers;

import com.example.Livrarias.controller.dto.CadastroLivroDto;
import com.example.Livrarias.model.autor.Livro;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-12T22:15:01-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class LivroMapperImpl extends LivroMapper {

    @Override
    public Livro toEntity(CadastroLivroDto dto) {
        if ( dto == null ) {
            return null;
        }

        Livro livro = new Livro();

        livro.setIsbn( dto.isbn() );
        livro.setTitulo( dto.titulo() );
        livro.setDataPublicaçao( dto.dataPublicaçao() );
        livro.setGenero( dto.genero() );
        livro.setPreço( dto.preço() );

        livro.setAutor( autorRepository.findById(dto.idAutor()).orElse(null) );

        return livro;
    }
}
