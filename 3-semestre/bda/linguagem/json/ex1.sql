use e_comerce;

-- A)
select distinct json_extract(e.navegador, '$.name') name, json_extract(e.navegador, '$.os') os
from eventos e
order by 1;

-- B)
select count(*) qtd, json_extract(e.navegador, '$.name') name
from eventos e
group by 2;

-- C)
select e.visitante, sum(json_extract(e.propriedades, '$.amount')) amount
from eventos e
where e.nome_evento = 'purchase'
group by 1;

-- D)
drop function if exists formata_resolucao;
create function formata_resolucao(var_resolution json) returns varchar(20)
begin
    return concat(json_extract(var_resolution, '$.x'), ' X ', json_extract(var_resolution, '$.y'));
end;

select distinct json_extract(e.navegador, '$.name')                          name,
                formata_resolucao(json_extract(e.navegador, '$.resolution')) resolucao
from eventos e;

-- E)
select max(json_extract(e.navegador, '$.resolution.x') * json_extract(e.navegador, '$.resolution.y')) maior,
       min(json_extract(e.navegador, '$.resolution.x') * json_extract(e.navegador, '$.resolution.y')) menor
from eventos e;

-- F)
select *
from eventos e
where e.nome_evento = 'purchase'
  and json_extract(e.propriedades, '$.amount') >= 400;
