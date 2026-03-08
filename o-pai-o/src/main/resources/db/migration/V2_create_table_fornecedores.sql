CREATE TABLE fornecedores(
    id UUID DEFAULT gen_random_uui() PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(100),
    telefone VARCHAR(100) NOT NULL,
    email VARCHAR(200),
    endereco VARCHAR(255),
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    data_cadastro TIMESTAMP NOT NULL
);