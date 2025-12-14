package com.example.Livrarias.mappers;

import com.example.Livrarias.controller.dto.AutorDTO;
import com.example.Livrarias.model.autor.Autor;
import java.time.LocalDate;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-12T18:06:08-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.44.0.v20251118-1623, environment: Java 25.0.1 (Eclipse Adoptium)"
)
@Component
public class AutorMapperImpl implements AutorMapper {

    @Override
    public Autor toEntity(AutorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Autor autor = new Autor();

        autor.setId( dto.getId() );
        autor.setName( dto.getName() );
        autor.setDataNascimento( dto.getDataNascimento() );
        autor.setNascionalidade( dto.getNascionalidade() );

        return autor;
    }

    @Override
    public AutorDTO toDTO(Autor autor) {
        if ( autor == null ) {
            return null;
        }

        UUID id = null;
        String name = null;
        LocalDate dataNascimento = null;
        String nascionalidade = null;

        id = autor.getId();
        name = autor.getName();
        dataNascimento = autor.getDataNascimento();
        nascionalidade = autor.getNascionalidade();

        AutorDTO autorDTO = new AutorDTO( id, name, dataNascimento, nascionalidade );

        return autorDTO;
    }
}
