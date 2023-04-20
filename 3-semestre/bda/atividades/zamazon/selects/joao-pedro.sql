use zamazon;

-- Questão 4) (Subconsultas)

-- Letra a) A Zamazon está sempre preocupada com o bom engajamento dos seus clientes, e deseja criar uma campanha para insentivar os
-- seus clientes que tem um gasto medio baixo a subirem esta media de gasto, para isso, gere um relatorio que traga todos os clientes
-- que gastaram menos que a media em seus pedidos.

-- clientes que gastaram menos que a media por pedidos
select nome, email
from cliente c
where c.id_cliente in (select cliente_id from pedido group by cliente_id having sum(preco_total) < (select ROUND(avg(preco_total), 2) from pedido));


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


-- Questão 5) (Junção interna e externa)

-- Letras a) A Zamazon está pensando em lançar uma oferta de frete gratis em alguns produtos de forma a insentivar os clientes a
-- comprarem mais, para isso, faça um relatorio que traga quais lojas/produtos tem menores valores gasto com fretes, para que a
-- Zamazon coniga abonar os fretes de produtos que não custem muito para o seu orçamento.

-- Valor total gasto em frete por loja e produto
select l.nome as loja, prod.nome as produto, sum(p.frete_total) as vlr_gasto_frete
from pedido p
         left join pedido_produto pp on p.id_pedido = pp.pedido_id
         left join produto prod on prod.id_produto = pp.produto_id
         left join loja l on l.id_loja = prod.loja_id
group by pp.produto_id
order by vlr_gasto_frete desc;


-- Letra b) A Zamazon disponibiliza o pagamento avista e parcelado, porém no modelo parcelado é pago um alto valor de taxa para
-- os cartões, com isso faça um relatorio que traga o produto que está sendo mais parcelado e sua respectiva loja, para que a Zamazon
-- consiga gerar uma oferta para esta loja e produto, no intuito de tentar converter mais clientes a comprarem o produto avista,
-- evitando o pagamento de taxas de cartões.

-- Produto que foi parcelado mais vezes nos pedidos
select l.nome as loja, prod.nome as produto, count(*) as qtd_pedidos_parcelado
from pedido p
         inner join pedido_produto pp on pp.pedido_id = p.id_pedido
         inner join produto prod on prod.id_produto = pp.produto_id
         inner join loja l on l.id_loja = prod.loja_id
where p.n_parcelas > 1
group by prod.id_produto
order by qtd_pedidos_parcelado desc
limit 1;
