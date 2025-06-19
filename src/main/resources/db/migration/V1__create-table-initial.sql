CREATE TABLE profissional (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    especialidade VARCHAR(255),
    crm VARCHAR(255),
    email VARCHAR(255),
    telefone VARCHAR(255),
    ativo BOOLEAN
);

CREATE TABLE paciente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    telefone VARCHAR(255),
    data_nascimento DATE,
    ativo BOOLEAN
);

CREATE TABLE consulta (
    id SERIAL PRIMARY KEY,
    data_hora TIMESTAMP NOT NULL,
    profissional_id INTEGER REFERENCES profissional(id),
    paciente_id INTEGER REFERENCES paciente(id),
    status VARCHAR(50),
    valor NUMERIC(10,2)
);

CREATE TABLE pagamento (
    id SERIAL PRIMARY KEY,
    consulta_id INTEGER UNIQUE REFERENCES consulta(id),
    valor NUMERIC(10,2),
    data_pagamento TIMESTAMP,
    status VARCHAR(50)
);

CREATE TABLE prontuario (
    id SERIAL PRIMARY KEY,
    paciente_id INTEGER REFERENCES paciente(id),
    profissional_id INTEGER REFERENCES profissional(id),
    data_registro TIMESTAMP,
    descricao TEXT
);
