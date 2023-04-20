use zamazon;

-- Questão 4) (Subconsultas)


-- Nome cliente, nome impresso no cartão, Valor total da compra, Quantidade de parcelas e Valor por parcela
select c.nome, ct.nome, p.preco_total as total, p.n_parcelas as parcelas, p.preco_total / p.n_parcelas as valorParcelas
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


-- Questão 5) (Junção interna e externa)


-- Nome cliente, numero de compras, Últimos 12 meses
select c.nome, nvl(count(p.id_pedido), 0) comprasPeriodo12Meses
from cliente c
         left join pedido p on c.id_cliente = p.cliente_id
where p.data_pedido in (select p.data_pedido from pedido p where p.data_pedido > DATE_SUB(current_date(), INTERVAL 12 MONTH))
group by c.nome;

-- Nome do produto, prazo de entrega, produtos entregues em menos de 7 dias
select c.nome, p.id_pedido, p.data_pedido, p.data_entrega, day(p.data_entrega) - day(p.data_pedido) as prazoEntrega
from cliente c
         join pedido p on c.id_cliente = p.cliente_id
where p.data_entrega in (select p.data_entrega from pedido p where p.data_pedido < DATE_SUB(current_date(), INTERVAL 7 DAY));
