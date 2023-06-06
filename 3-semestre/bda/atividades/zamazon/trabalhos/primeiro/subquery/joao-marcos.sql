use zamazon;

-- Nome cliente, nome impresso no cartão, Valor total da compra, Quantidade de parcelas e Valor por parcela
select c.nome,
       ct.nome,
       p.preco_total                as total,
       p.n_parcelas                 as parcelas,
       p.preco_total / p.n_parcelas as valorParcelas
from cliente c
         join cartao ct
         join pedido p on c.id_cliente = ct.cliente_id and ct.id_cartao = p.cartao_id;

-- Nome cliente, nome impresso no cartão, valor gasto por cartão
select c.nome, ct.nome, nvl(sum(p.preco_total), 0) totalGasto
from cliente c
         join cartao ct on c.id_cliente = ct.cliente_id
         left join pedido p on ct.id_cartao = p.cartao_id
group by ct.nome
order by totalGasto desc;
