use zamazon;

-- A) Altera a data da entrega para hoje e adiciona mais 10 reais em todos os pedidos que ainda não foram entreges
update pedido
set frete        = frete + 10,
    dataEntrega  = now(),
    statusPedido = 'Entregue'
where statusPedido = 'Em transporte';

-- B) Exclui todos os cartões vencido
delete
FROM cartao
WHERE expiracao < now();

-- C) Cria uma tabela para armazenar o produto e a média de avaliaçoes
drop table if exists produtoAvaliacao;
create table produtoAvaliacao
(
    produtoId      int primary key,
    mediaAvaliacao numeric(2, 1)
);
insert into produtoAvaliacao (produtoId, mediaAvaliacao)
select c.produtoId, avg(c.avaliacao)
from comentario c
group by 1;

-- D) Criar uma tabela temporaria com o preço total de cada carrinho
drop temporary table if exists carrinhoTotal;
create temporary table carrinhoTotal as
select clienteId, sum(preco * quantidade) total
from carrinho c2
         join produto p on p.id = c2.produtoId
group by 1;
