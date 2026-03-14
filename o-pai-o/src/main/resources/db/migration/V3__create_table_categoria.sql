CREATE TABLE categorias(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY ,
    nome VARCHAR(100) UNIQUE NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    data_criacao TIMESTAMP NOT NULL
);