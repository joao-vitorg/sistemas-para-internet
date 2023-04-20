use zamazon;

-- Questão 4) (Subconsultas)

-- Letra a) O nome e preço dos produtos em que preço é maior que a média de preço de todos os produtos da loja
SELECT p.nome, p.preco
FROM produto p
WHERE p.preco > (SELECT AVG(preco) FROM produto);

-- Letra b) nome do produto e da categoria, apenas dos produtos que custam mais de 50 unidades monetárias (a moeda não está especificada na tabela).
SELECT p.nome, c.descricao as categoria
FROM produto p
         JOIN categoria c on p.categoria_id = c.id_categoria
WHERE p.preco > 2000.00
ORDER BY c.descricao, p.nome;


-- Questão 5) (Junção interna e externa)


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
