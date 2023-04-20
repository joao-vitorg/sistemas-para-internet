use zamazon;

-- Letra a) Elabore um relatório contendo a situação da meta em cada mês, levando em consideração que, para que a meta seja alcançada,
-- é necessário que a loja venda mais do que a média de vendas de todos os meses anteriores.

(select vrv.nome, vrv.ano, vrv.mes, vrv.ganho_total, concat('Bateu a meta') situacao
 from vw_vendas vrv
 where ganho_total >= coalesce(
         (select avg(v.ganho_total) from vw_vendas v where v.id_loja = vrv.id_loja and ((v.ano < vrv.ano) or (vrv.ano = v.ano and v.mes < vrv.mes))),
         0))
union all
(select vrv.nome, vrv.ano, vrv.mes, vrv.ganho_total, concat('Não bateu a meta') situacao
 from vw_vendas vrv
 where ganho_total < coalesce(
         (select avg(v.ganho_total) from vw_vendas v where v.id_loja = vrv.id_loja and ((v.ano < vrv.ano) or (vrv.ano = v.ano and v.mes < vrv.mes))),
         0))
order by 1, 2, 3;

-- Letra B) Elabore um relatório que liste todos os clientes do zamazon e marque-os como frequente e não frequente caso ele tenha realizado 
-- mais pedidos que a media dos clientes.

(select c.nome, c.email, 'Frequente' as situacao
 from cliente c
          left join pedido p on p.cliente_id = c.id_cliente
 group by c.id_cliente
 having count(p.id_pedido) >= (select format(count(1) / (select count(1) from cliente), 2) as media_pedidos from pedido)
 order by c.id_cliente desc)
union all
(select c.nome, c.email, 'Infrequente' as situacao
 from cliente c
          left join pedido p on p.cliente_id = c.id_cliente
 group by c.id_cliente
 having count(p.id_pedido) < (select format(count(1) / (select count(1) from cliente), 2) as media_pedidos from pedido)
 order by c.id_cliente desc);
