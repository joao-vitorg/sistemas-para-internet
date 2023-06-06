use zamazon;

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
