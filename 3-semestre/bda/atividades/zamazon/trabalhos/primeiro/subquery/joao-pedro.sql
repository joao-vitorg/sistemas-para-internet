use zamazon;

-- Letra a) A Zamazon está sempre preocupada com o bom engajamento dos seus clientes, e deseja criar uma campanha para insentivar os
-- seus clientes que tem um gasto medio baixo a subirem esta media de gasto, para isso, gere um relatorio que traga todos os clientes
-- que gastaram menos que a media em seus pedidos.

-- clientes que gastaram menos que a media por pedidos
select nome, email
from cliente c
where c.id_cliente in (select cliente_id
                       from pedido
                       group by cliente_id
                       having sum(preco_total) < (select ROUND(avg(preco_total), 2) from pedido));


-- Letra b) A Zamazon em parceria com a Samsung, quer presentear com cupoms de descontos da sansumg, todos os usuarios que
-- renovaram os celulares de sua familia comprando os novos Galaxy S20, para ajusar eles a identificar quem deverá ganhar o
-- presente, faça um relatorio que traga todos os clientes que compraram mais de 1 Galaxy S20.

-- Clientes que compraram mais de 2 celulares samsung galaxy
select c.nome, c.email
from cliente c
where c.id_cliente in (select p.cliente_id
                       from pedido p
                                inner join pedido_produto pp on pp.pedido_id = p.id_pedido
                                inner join produto prod on prod.id_produto = pp.produto_id
                       where prod.nome = 'Galaxy S20'
                       group by p.cliente_id
                       having count(pp.quantidade) >= 2);
