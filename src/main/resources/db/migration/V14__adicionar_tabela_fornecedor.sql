CREATE TABLE fornecedor (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    razao_social VARCHAR(80) NOT NULL,
    cnpj VARCHAR(30),
    telefone VARCHAR(20),
    email VARCHAR(50) NOT NULL,
    logradouro VARCHAR(50),
    numero VARCHAR(15),
    complemento VARCHAR(20),
    cep VARCHAR(15),
    codigo_cidade BIGINT(20),
    FOREIGN KEY (codigo_cidade) REFERENCES cidade(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;