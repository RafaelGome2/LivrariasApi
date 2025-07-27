CREATE TABLE  IF NOT EXISTS library.public.autor (
    id              uuid         NOT NULL PRIMARY KEY,
    name            varchar(100) NOT NULL,
    data_nascimento date         NOT NULL,
    nascionalidade  varchar(50)  NOT NULL
);

CREATE TABLE IF NOT EXISTS library.public.livro (
    id              uuid           NOT NULL PRIMARY KEY,
    isbn            varchar(20)    NOT NULL,
    titulo          varchar(150)   NOT NULL,
    data_publicaçao date           NOT NULL,
    genero          varchar(30)    NOT NULL,
    preço           numeric(18, 2) NULL,
    id_autor        uuid           NOT NULL REFERENCES autor(id),
    CONSTRAINT chk_genero CHECK (genero IN ('FICÇAO', 'FANTASIA', 'MISTERIO', 'ROMANCE', 'BIOGRAFIA', 'CIENCIA'))
);