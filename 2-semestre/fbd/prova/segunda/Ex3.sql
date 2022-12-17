-- EX3 João Vitor Gomes de Souza
use voebem;

-- A
select p.*
from piloto p
         join companhia c on c.cod_cia = p.cod_cia
where c.sigla in ('TAM', 'TAP');

-- B
select a.cidade_aeroporto, v.hora
from voo v
         join aeroporto a on a.codigo_aeroporto = v.aeroporto_destimo
where v.codigo_voo = 'A200';

-- C
select v.codigo_voo, e.data_voo, v.hora
from voo v
         join aeroporto a on a.codigo_aeroporto = v.aeroporto_destimo
         join escala e on v.codigo_voo = e.codigo_voo
where a.cidade_aeroporto = 'Guarulhos';

-- D
select destino.cidade_aeroporto, v.hora
from voo v
         join aeroporto origem on origem.codigo_aeroporto = v.aeroporto_origem
         join aeroporto destino on destino.codigo_aeroporto = v.aeroporto_destimo
where origem.cidade_aeroporto = 'Uberlândia'
  and hour(v.hora) >= 12;

-- E
select count(*)
from voo v
         join aeroporto a on a.codigo_aeroporto = v.aeroporto_origem
         join escala e on v.codigo_voo = e.codigo_voo
where a.cidade_aeroporto = 'Uberlândia'
  and month(e.data_voo) in (5, 6);

-- F
select p.nome_piloto, c.sigla, v.codigo_voo, e.data_voo, origem.cidade_aeroporto, destimo.cidade_aeroporto
from escala e
         join piloto p on p.codigo_piloto = e.codigo_piloto
         join companhia c on p.cod_cia = c.cod_cia
         join voo v on v.codigo_voo = e.codigo_voo
         join aeroporto origem on v.aeroporto_origem = origem.codigo_aeroporto
         join aeroporto destimo on v.aeroporto_destimo = destimo.codigo_aeroporto;

-- G
select min(p.salario), max(p.salario), avg(p.salario), min(p.gratidicacao), avg(p.gratidicacao)
from piloto p;

-- H
select c.sigla, count(*)
from escala e
         join piloto p on p.codigo_piloto = e.codigo_piloto
         join companhia c on c.cod_cia = p.cod_cia
group by 1;

-- I
select p.nome_piloto, c.nome_comp
from escala e
         join piloto p on p.codigo_piloto = e.codigo_piloto
         join companhia c on c.cod_cia = p.cod_cia
group by 1
having count(*) > 1;

-- J
select p.nome_piloto, p.salario, p.gratidicacao
from piloto p
order by 2 desc;
