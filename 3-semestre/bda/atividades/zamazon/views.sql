use zamazon;

-- Letra a) Para a segurança da Zamazon, crie uma View com todos os dados dos clientes menos a senha
drop view if exists vw_clientes;
create view vw_clientes as
select id_cliente, email, nome, telefone, cpf, dt_nascimento, sexo
from cliente c;


-- Letra b) View com o relatório de vendas por ano e por mês
drop view if exists vw_vendas;
create view vw_vendas as
select l.id_loja,
       l.nome,
       year(p2.data_pedido)          ano,
       month(p2.data_pedido)         mes,
       count(*)                      qtd_vendas,
       sum(pp.preco * pp.quantidade) ganho_total,
       sum(pp.frete)                 total_frete
from loja l
         join produto p on l.id_loja = p.loja_id
         join pedido_produto pp on p.id_produto = pp.produto_id
         join pedido p2 on pp.pedido_id = p2.id_pedido
group by 1, 3, 4;

-- View com o relatório de todos os produtos
drop view if exists vw_produtos;
create view vw_produtos as
select p.id_produto,
       p.nome,
       c2.descricao                            catregoria,
       l.nome                                  loja,
       p.preco,
       p.estoque,
       sum(pp.quantidade)                      qtd_vendidos,
       coalesce(round(avg(c.avaliacao), 2), 0) avaliacao_media
from produto p
         join loja l on l.id_loja = p.loja_id
         join pedido_produto pp on p.id_produto = pp.produto_id
         left join comentario c on p.id_produto = c.produto_id
         join categoria c2 on p.categoria_id = c2.id_categoria
group by 1;
