
Esquema do banco 

-- Tabela de clientes
CREATE TABLE IF NOT EXISTS clientes (
id         SERIAL PRIMARY KEY,
nome       TEXT NOT NULL,
email      TEXT,
telefone   TEXT,
CONSTRAINT email_unique UNIQUE (email)
);

-- Tabela de pets
CREATE TABLE IF NOT EXISTS pets (
id         SERIAL PRIMARY KEY,
nome       TEXT NOT NULL,
especie    TEXT,
raca       TEXT,
idade      INTEGER,
cliente_id INTEGER REFERENCES clientes (id)
);

-- Tabela de serviços
CREATE TABLE IF NOT EXISTS servicos (
id         SERIAL PRIMARY KEY,
nome       TEXT NOT NULL,
descricao  TEXT,
preco      NUMERIC(10, 2),
duracao    INTERVAL
);

-- Tabela de produtos
CREATE TABLE IF NOT EXISTS produtos (
id         SERIAL PRIMARY KEY,
nome       TEXT NOT NULL,
descricao  TEXT,
preco      NUMERIC(10, 2),
quantidade INTEGER
);

-- Tabela de agendamentos de serviços
CREATE TABLE IF NOT EXISTS agendamentos (
id            SERIAL PRIMARY KEY,
data_hora     TIMESTAMP,
servico_id    INTEGER REFERENCES servicos (id),
pet_id        INTEGER REFERENCES pets (id),
cliente_id    INTEGER REFERENCES clientes (id)
);

-- Tabela de veterinários
CREATE TABLE IF NOT EXISTS veterinarios (
id         SERIAL PRIMARY KEY,
nome       TEXT  
);

-- Tabela de especialidades
CREATE TABLE IF NOT EXISTS especialidades (
id   SERIAL PRIMARY KEY,
nome TEXT
);

-- Tabela de relacionamento entre veterinários e especialidades
CREATE TABLE IF NOT EXISTS especialidades_veterinarias (
veterinario_id       INT NOT NULL REFERENCES veterinarios (id),
especialidade_id INT NOT NULL REFERENCES especialidades (id),
UNIQUE (veterinario_id, especialidade_id)
);

-- Tabela de tipos de pets
CREATE TABLE IF NOT EXISTS tipos (
id   SERIAL PRIMARY KEY,
nome TEXT
);

-- Índices para melhorar a performance de consultas frequentes
CREATE INDEX IF NOT EXISTS idx_cliente_id ON pets (cliente_id);
CREATE INDEX IF NOT EXISTS idx_servico_id ON agendamentos (servico_id);
CREATE INDEX IF NOT EXISTS idx_pet_id ON agendamentos (pet_id);
CREATE INDEX IF NOT EXISTS idx_cliente_id_agendamentos ON agendamentos (cliente_id);
CREATE INDEX IF NOT EXISTS idx_veterinario_id ON especialidades_veterinarias (veterinario_id);
CREATE INDEX IF NOT EXISTS idx_especialidade_id ON especialidades_veterinarias (especialidade_id);
CREATE INDEX IF NOT EXISTS idx_tipo_id ON pets (tipo_id);


