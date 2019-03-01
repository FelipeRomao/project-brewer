CREATE TABLE estado (
	codigo BIGINT(20) PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	sigla VARCHAR(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cidade(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	codigo_estado BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_estado) REFERENCES estado(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 INSERT INTO estado (codigo,sigla,nome) VALUES(1,'AC','Acre');  
 INSERT INTO estado (codigo,sigla,nome) VALUES(2,'AL','Alagoas');  
 INSERT INTO estado (codigo,sigla,nome) VALUES(3,'AM','Amazonas');
 INSERT INTO estado (codigo,sigla,nome) VALUES(4,'AP','Amapá');
 INSERT INTO estado (codigo,sigla,nome) VALUES(5,'BA','Bahia');
 INSERT INTO estado (codigo,sigla,nome) VALUES(6,'CE','Ceará');
 INSERT INTO estado (codigo,sigla,nome) VALUES(7,'DF','Distrito Federal');
 INSERT INTO estado (codigo,sigla,nome) VALUES(8,'ES','Espírito Santo');
 INSERT INTO estado (codigo,sigla,nome) VALUES(9,'GO','Goiás');
 INSERT INTO estado (codigo,sigla,nome) VALUES(10,'MA','Maranhão');
 INSERT INTO estado (codigo,sigla,nome) VALUES(11,'MG','Minas Gerais');
 INSERT INTO estado (codigo,sigla,nome) VALUES(12,'MS','Mato Grosso do Sul');
 INSERT INTO estado (codigo,sigla,nome) VALUES(13,'MT','Mato Grosso');
 INSERT INTO estado (codigo,sigla,nome) VALUES(14,'PA','Pará');
 INSERT INTO estado (codigo,sigla,nome) VALUES(15,'PB','Paraíba');
 INSERT INTO estado (codigo,sigla,nome) VALUES(16,'PE','Pernambuco');
 INSERT INTO estado (codigo,sigla,nome) VALUES(17,'PI','Piauí');
 INSERT INTO estado (codigo,sigla,nome) VALUES(18,'PR','Paraná');
 INSERT INTO estado (codigo,sigla,nome) VALUES(19,'RJ','Rio de Janeiro');
 INSERT INTO estado (codigo,sigla,nome) VALUES(20,'RN','Rio Grande do Norte');
 INSERT INTO estado (codigo,sigla,nome) VALUES(21,'RO','Rondônia');
 INSERT INTO estado (codigo,sigla,nome) VALUES(22,'RR','Roraima');
 INSERT INTO estado (codigo,sigla,nome) VALUES(23,'RS','Rio Grande do Sul');
 INSERT INTO estado (codigo,sigla,nome) VALUES(24,'SC','Santa Catarina');
 INSERT INTO estado (codigo,sigla,nome) VALUES(25,'SE','Sergipe');
 INSERT INTO estado (codigo,sigla,nome) VALUES(26,'SP','São Paulo');
 INSERT INTO estado (codigo,sigla,nome) VALUES(27,'TO','Tocantins');
 
 
INSERT INTO cidade (nome, codigo_estado) VALUES ('Rio Branco', 1);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Cruzeiro do Sul', 1); 
INSERT INTO cidade (nome, codigo_estado) VALUES ('Salvador', 5);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Porto Seguro', 5);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Santana', 5);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Goiânia', 9);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Itumbiara', 9);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Novo Brasil', 9);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Belo Horizonte', 11);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Uberlândia', 11);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Montes Claros', 11);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Florianópolis', 24);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Criciúma', 24);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Camboriú', 24);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Lages', 24);
INSERT INTO cidade (nome, codigo_estado) VALUES ('São Paulo', 26);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Ribeirão Preto', 26);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Campinas', 26);
INSERT INTO cidade (nome, codigo_estado) VALUES ('Santos', 26);