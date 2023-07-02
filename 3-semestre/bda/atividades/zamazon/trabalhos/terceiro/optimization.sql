use zamazon;

-- 1-A) Clientes que tem o cep começando com 38

-- a) 15 + 1 rows
explain
select c.nome, e.cod_postal
from cliente c
         join endereco e on c.id_cliente = e.cliente_id
where e.cod_postal like '38%';

-- b)
alter table endereco
    add index (cod_postal(2));

-- 8 + 1 rows
explain
select c.nome, e.cod_postal
from cliente c
         join endereco e on c.id_cliente = e.cliente_id
where e.cod_postal like '38%';

-- c) 15 + 7 rows
explain
select c.nome, e.cod_postal
from cliente c straight_join endereco e on c.id_cliente = e.cliente_id
where e.cod_postal like '38%';

-- 1-B) Lojas que vendem produtos acima de 2000

-- a) 5 + 11 rows
explain
select *
from loja l
where l.id_loja in (select p.loja_id from produto p where p.preco > 2000);

-- b)
alter table produto
    add index (preco);

-- 5 + 5 rows
explain
select *
from loja l
where l.id_loja in (select p.loja_id from produto p where p.preco > 2000);

-- c) 2 + 1 rows
explain
select (select l.nome from loja l where l.id_loja = p.loja_id)
from produto p
where p.preco > 2000;

-- 1-C) O produto mais caro da loja

-- a) 11 + 1 rows
explain
select l.nome, max(p.preco)
from loja l straight_join produto p on p.loja_id = l.id_loja
group by 1;

-- a) 5 + 11 rows
explain
select l.nome, max(p.preco)
from loja l straight_join produto p on p.loja_id = l.id_loja
group by 1;
