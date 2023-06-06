use zamazon;

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
