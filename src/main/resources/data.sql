-- insert da tabela cliente
INSERT INTO cliente (id, nome, cpf, celular, email, datanascimento)
VALUES (1, 'João Silva', '123.456.789-00', '123456789', 'joao.silva@email.com', '1985-05-15'),
       (2, 'Maria Oliveira', '987.654.321-00', '987654321', 'maria.oliveira@email.com', '1990-09-25'),
       (3, 'Pedro Souza', '456.789.123-00', '456789123', 'pedro.souza@email.com', '1988-02-20'),
       (4, 'Ana Costa', '321.654.987-00', '321654987', 'ana.costa@email.com', '1995-12-10'),
       (5, 'Carlos Pereira', '654.321.987-00', '654321987', 'carlos.pereira@email.com', '1983-11-30');
--insert da tabela instFinanceira
INSERT INTO instfinanceira (id, codigo, nome, cnpj)
VALUES (1, 1001, 'Instituição Financeira A', '00.000.000/0001-00'),
       (2, 1002, 'Instituição Financeira B', '11.111.111/0001-11'),
       (3, 1003, 'Instituição Financeira C', '22.222.222/0001-22'),
       (4, 1004, 'Instituição Financeira D', '33.333.333/0001-33'),
       (5, 1005, 'Instituição Financeira E', '44.444.444/0001-44');
--insert da tabela lance
INSERT INTO lance (id, valor)
VALUES (1, 1000.00),
       (2, 1500.50),
       (3, 2000.75),
       (4, 2500.00),
       (5, 3000.25);
-- Inserir dados na tabela leilao
INSERT INTO leilao (id, datainicio, datafim, datavisitacao, dataevento, dominioleilaoeletronico, endereco, cidade,
                    estado)
VALUES (1, '2024-11-01 10:00:00', '2024-11-01 18:00:00', '2024-10-30 10:00:00', '2024-11-01 10:00:00',
        'leilaoeletronico.com', 'Rua A, 123', 'São Paulo', 'SP'),
       (2, '2024-12-05 10:00:00', '2024-12-05 18:00:00', '2024-12-03 10:00:00', '2024-12-05 10:00:00',
        'leilaoonline.com', 'Rua B, 456', 'Rio de Janeiro', 'RJ'),
       (3, '2025-01-10 10:00:00', '2025-01-10 18:00:00', '2025-01-08 10:00:00', '2025-01-10 10:00:00',
        'leilaoeletronico.net', 'Rua C, 789', 'Belo Horizonte', 'MG'),
       (4, '2025-02-15 10:00:00', '2025-02-15 18:00:00', '2025-02-13 10:00:00', '2025-02-15 10:00:00', 'leilao.digital',
        'Rua D, 101', 'Curitiba', 'PR'),
       (5, '2025-03-20 10:00:00', '2025-03-20 18:00:00', '2025-03-18 10:00:00', '2025-03-20 10:00:00',
        'leilaoexpress.com', 'Rua E, 202', 'Porto Alegre', 'RS');

-- Inserindo dados na tabela Produto
INSERT INTO Produto (id, tipo, complemento, precoInicial, status, leilao_id)
VALUES (1, 'Eletrônico', 'Smartphone Samsung Galaxy', 2500.00, 'Disponível', 1),
       (2, 'Eletrônico', 'Notebook Dell', 5000.00, 'Disponível', 2),
       (3, 'Eletrônico', 'Monitor LG 24" Full HD', 1200.00, 'Disponível', 3),
       (4, 'Veículo', 'Carro Honda Civic', 90000.00, 'Disponível', 4),
       (5, 'Veículo', 'Carro Toyota Corolla', 95000.00, 'Disponível', 5),
       (6, 'Eletrônico', 'Tablet Apple iPad', 3500.00, 'Disponível', 1),
       (7, 'Eletrônico', 'Impressora HP LaserJet Pro', 800.00, 'Disponível', 2),
       (8, 'Veículo', 'Moto Yamaha XJ6', 22000.00, 'Disponível', 3),
       (9, 'Veículo', 'Carro Chevrolet Onix', 60000.00, 'Disponível', 4),
       (10, 'Eletrônico', 'Fone de ouvido JBL', 500.00, 'Disponível', 5);
-- Inserindo dados na tabela DispInformatica
INSERT INTO DispInformatica (id, tipoDispositivo, marca, modelo)
VALUES (1, 0, 'Samsung', 'Galaxy S21'),
       (2, 1, 'Dell', 'XPS 15'),
       (3, 2, 'TP-Link', 'Archer C7'),
       (4, 3, 'Netgear', 'GS108'),
       (5, 4, 'TP-Link', 'TL-WR841N');
-- Inserindo dados na tabela Veiculo
INSERT INTO Veiculo (id, tipoVeiculo, marca, modelo, ano, cor, kmRodados, placa)
VALUES (4, 0, 'Honda', 'Civic', 2020, 'Preto', 15000.0, 'XYZ-1234'),
       (5, 1, 'Toyota', 'Corolla', 2021, 'Branco', 10000.0, 'ABC-5678'),
       (6, 0, 'Chevrolet', 'Onix', 2022, 'Cinza', 5000.0, 'DEF-3456'),
       (7, 2, 'Yamaha', 'XJ6', 2020, 'Preto', 7000.0, 'GHI-7890'),
       (8, 3, 'Ford', 'Fiesta', 2019, 'Vermelho', 30000.0, 'JKL-0123');