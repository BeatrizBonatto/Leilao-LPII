CREATE DATABASE LeilaoBeatrizBonatto;

USE DATABASE LeilaoBeatrizBonatto;

CREATE TABLE Cliente (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         cpf VARCHAR(11) NOT NULL UNIQUE,
                         nome VARCHAR(255) NOT NULL,
                         data_de_nascimento DATE NOT NULL,
                         email VARCHAR(255),
                         celular BIGINT
);

CREATE TABLE TipoDispositivo (
                                 id INT PRIMARY KEY AUTO_INCREMENT,
                                 tipo_dispositivo VARCHAR(50) NOT NULL
);

CREATE TABLE DispInformatica (
                                 id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                 tipo_dispositivo_id INT,
                                 marca VARCHAR(100),
                                 modelo VARCHAR(100),
                                 FOREIGN KEY (tipo_dispositivo_id) REFERENCES TipoDispositivo(id)
);

CREATE TABLE InstFinanceira (
                                id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                codigo BIGINT NOT NULL UNIQUE,
                                nome VARCHAR(255) NOT NULL,
                                cnpj DECIMAL(14, 0) NOT NULL UNIQUE
);

CREATE TABLE Leilao (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        data_inicio TIMESTAMP NOT NULL,
                        data_fim TIMESTAMP NOT NULL,
                        data_visitacao TIMESTAMP,
                        data_evento TIMESTAMP,
                        dominio_leilao_eletronico VARCHAR(255),
                        endereco VARCHAR(255),
                        cidade VARCHAR(100),
                        estado VARCHAR(50),
                        status VARCHAR(50)
);

CREATE TABLE Produto (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         tipo VARCHAR(100),
                         complemento VARCHAR(255),
                         preco_inicial DECIMAL(10, 2)
);

CREATE TABLE TipoVeiculo (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             tipo_veiculo VARCHAR(50) NOT NULL
);

CREATE TABLE Veiculo (
                         id BIGINT PRIMARY KEY,
                         tipo_veiculo_id INT,
                         marca VARCHAR(100),
                         modelo VARCHAR(100),
                         ano INT,
                         cor VARCHAR(50),
                         km_rodados DOUBLE,
                         placa VARCHAR(10),
                         FOREIGN KEY (id) REFERENCES Produto(id),
                         FOREIGN KEY (tipo_veiculo_id) REFERENCES TipoVeiculo(id)
);

-- Inserts no banco dos tipos de produto existentes
INSERT INTO TipoDispositivo (tipo_dispositivo) VALUES ('Notebook');
INSERT INTO TipoDispositivo (tipo_dispositivo) VALUES ('Monitor');
INSERT INTO TipoDispositivo (tipo_dispositivo) VALUES ('Hub');
INSERT INTO TipoDispositivo (tipo_dispositivo) VALUES ('Switch');
INSERT INTO TipoDispositivo (tipo_dispositivo) VALUES ('Roteador');

INSERT INTO TipoVeiculo (tipo_veiculo) VALUES ('Carro de passeio');
INSERT INTO TipoVeiculo (tipo_veiculo) VALUES ('Moto de passeio');
INSERT INTO TipoVeiculo (tipo_veiculo) VALUES ('Caminhão');
INSERT INTO TipoVeiculo (tipo_veiculo) VALUES ('Utilitário');