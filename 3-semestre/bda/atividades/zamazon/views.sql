use zamazon;

-- View com todos os dados dos clientes menos a senha
drop view if exists vw_clientes;
create view vw_clientes as
select id, email, nome, telefone, cpf, dt_nascimento, sexo
from cliente c;


-- View com o relatório de vendas por ano e por mês
drop view if exists vw_vendas;
create view vw_vendas as
select l.id,
       l.nome,
       year(p2.data_pedido)          ano,
       month(p2.data_pedido)         mes,
       count(*)                      qtd_vendas,
       sum(pp.preco * pp.quantidade) ganho_total,
       sum(pp.frete)                 total_frete
from loja l
         join produto p on l.id = p.loja_id
         join pedido_produto pp on p.id = pp.produto_id
         join pedido p2 on pp.pedido_id = p2.id
group by 1, 3, 4;
