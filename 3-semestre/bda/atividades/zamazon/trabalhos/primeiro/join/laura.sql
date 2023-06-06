use zamazon;

-- Letra a) O nome da loja e respectivo número de produtos separados por categoria
SELECT l.nome, c.descricao AS categoria, COUNT(*) AS num_produtos
FROM loja l
         INNER JOIN produto p ON l.id_loja = p.loja_id
         INNER JOIN categoria c ON p.categoria_id = c.id_categoria
GROUP BY l.nome, c.descricao;

-- Letra b) O nome da loja e o nome dos produtos que ela vende
SELECT l.nome, p.nome
FROM loja l
         INNER JOIN produto p ON p.loja_id = l.id_loja;
