use zamazon;

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
