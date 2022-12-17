use zamazon;

-- 3a seleciona os produtos que tem o preço menor igual que 1000
select *
from produto p
where p.preco <= 1000;

-- 3b seleciona os produtos da encomenda que tem mais de 1 produtos
select *
from produtoEncomenda E
where E.quantidade > 1;

-- 3c seleciona os clientes que o cpf começa com 1
select *
from cliente c
where c.cpf like '1%';

-- 3d seleciona os pedidos processado e entregue
select *
from pedido p
where p.statusPedido in ('Processando', 'Entregue');

-- 3e seleciona os comentarios que tem de 4 a 5 estrelas
select *
from comentario c
where c.avaliacao between 4 and 5;

-- 4a seleciona o produto e as categoria
select p.nome, c.descricao
from produto p
         join categoria c on c.id = p.categoriaId;

-- 4b seleciona o nome do cliente, o nome do produto e a quantidade no carrinho
select c2.nome, p.nome, c.quantidade
from carrinho c
         join cliente c2 on c2.id = c.clienteId
         join produto p on p.id = c.produtoId;

-- 4c seleciona o produto, o cliente e a quantidade do pedido
select p2.nome, c.nome, pP.quantidade
from pedido p
         join cliente c on c.id = p.clienteId
         join pedidoProduto pP on p.id = pP.pedidoId
         join produto p2 on p2.id = pP.produtoId;

-- 4d seleciona o produto e os comentarios
select p.nome, c.comentario
from produto p
         join comentario c on c.produtoId = p.id;

-- 4e seleciona o fornecedor e os produtos da encomenda
select f.nome, p.nome
from encomenda e
         join fornecedor f on f.id = e.fornecedorId
         join produtoEncomenda pE on pE.encomendaId = e.id
         join produto p on p.id = pE.produtoId;

-- 5a seleciona a quantidade gastas por cliente
select c.nome, sum(pP.preco * pP.quantidade) as total
from pedido p
         join cliente c on c.id = p.clienteId
         join pedidoProduto pP on p.id = pP.pedidoId
group by c.id;

-- 5b seleciona o valor de cada cliente no carrinho
select c2.nome, sum(p.preco * c.quantidade) as total
from carrinho c
         join cliente c2 on c2.id = c.clienteId
         join produto p on p.id = c.produtoId
group by c.clienteId;

-- 5c seleciona a media de gasto de cada cartão
select c2.numero, avg(pP.preco * pP.quantidade) as media
from pedido p
         join cartao c2 on c2.id = p.cartaoId
         join pedidoProduto pP on p.id = pP.pedidoId
group by c2.id;

-- 5d seleciona a quantidade de produtos vendidos por categoria
select c.descricao, sum(pP.quantidade) as total
from pedido p
         join pedidoProduto pP on p.id = pP.pedidoId
         join produto p2 on p2.id = pP.produtoId
         join categoria c on c.id = p2.categoriaId
group by c.id;

-- 5e seleciona a quantidade de pedidos por endereco
select e.endereco, count(*) as total
from pedido p
         join endereco e on e.id = p.enderecoId
group by e.id;
