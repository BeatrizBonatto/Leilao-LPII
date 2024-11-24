-- Inserindo Clientes
INSERT INTO Cliente (id, nome, cpf, data_nascimento)
VALUES
    (2, 'Beatriz Bonatto', '12345678900', DATE '1995-05-20'),
    (1, 'João Silva', '98765432100', DATE '1987-11-15');

-- Inserindo Instituições Financeiras
INSERT INTO Inst_Financeira (id, codigo, nome, cnpj)
VALUES
    (1, 1001, 'Banco Central', '12345678000199'),
    (2, 1002, 'Banco do Povo', '98765432000199');

-- Inserindo Leilões
INSERT INTO Leilao (id, data_inicio, data_fim, data_visita, dominio_leilao_eletronico, endereco, cidade, estado)
VALUES
    (1, TIMESTAMP '2024-12-01 10:00:00', TIMESTAMP '2024-12-05 18:00:00', TIMESTAMP '2024-11-30 14:00:00',
     'www.leilaoeletronico.com', 'Av. Paulista, 1000', 'São Paulo', 'SP'),
    (2, TIMESTAMP '2024-12-10 10:00:00', TIMESTAMP '2024-12-15 18:00:00', TIMESTAMP '2024-12-09 14:00:00',
     'www.leilaoeletronico2.com', 'Rua das Flores, 123', 'Rio de Janeiro', 'RJ');

-- Inserindo Produtos (usando "descricao" no lugar de "complemento")
INSERT INTO Produto (id, sub_tipo, descricao, preco_inicial, leilao_id)
VALUES
    (1, 'CARRO', 'Carro Hatchback Azul', 20000.00, 1),
    (2, 'NOTEBOOK', 'Notebook Dell 15 polegadas', 3000.00, 2);

-- Inserindo Lances
INSERT INTO Lance (id, cliente_id, produto_id, valor)
VALUES
    (1, 1, 1, 5000.00), -- Cliente João Silva deu um lance no produto 1 (Carro)
    (2, 2, 2, 15000.00); -- Cliente Beatriz Bonatto deu um lance no produto 2 (Notebook)

INSERT INTO instfinanceira_leilao(leilao_id, instfinanceira_id)
VALUES
    (1,1),
    (1,2);
