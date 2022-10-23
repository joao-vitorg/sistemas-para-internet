use clinica;

-- a
select m.nomem, year(c.dt_consulta), count(*)
from consulta c
	     join medico m on m.codm = c.codm
group by 1, 2;

-- b
select m.especialidade, sum(c.valor_consulta)
from consulta c
	     join medico m on m.codm = c.codm
group by 1
ORDER BY 2 desc;

-- c
select month(c.dt_consulta), m.nomem, sum(c.valor_consulta)
from consulta c
	     join medico m on c.codm = m.codm
group by 1, 2;

-- d
select m.nomem, year(c.dt_consulta), count(*), avg(c.valor_consulta)
from consulta c
	     join medico m on c.codm = m.codm
group by 1, 2;

-- e
select p.problema, count(*)
from paciente p
group by 1;

-- f
select m.nomem, max(c.valor_consulta), min(c.valor_consulta)
from consulta c
	     join medico m on c.codm = m.codm
where year(c.dt_consulta) = 2017
group by 1;

-- g
select m.nomem, count(distinct p.codp)
from consulta c
	     join medico m on c.codm = m.codm
	     join paciente p on p.codp = c.codp
group by 1 asc;

-- h
select m.nomem, count(*), avg(c.valor_consulta)
from consulta c
	     join medico m on m.codm = c.codm
group by 1
having count(year(c.dt_consulta) = 2017) > 1;

-- i
select m.nomem, year(c.dt_consulta), sum(c.valor_consulta)
from consulta c
	     join medico m on c.codm = m.codm
group by 1, 2
having avg(c.valor_consulta) > 145
   and count(*) > 1;

-- j
select m.especialidade, min(c.valor_consulta), max(c.valor_consulta)
from consulta c
	     join medico m on c.codm = m.codm
group by 1;

-- k
select m.especialidade, sum(c.valor_consulta)
from consulta c
	     join medico m on c.codm = m.codm
group by 1;

-- l
select p.nomep, year(c.dt_consulta), sum(c.valor_consulta)
from consulta c
	     join paciente p on c.codp = p.codp
group by p.codp, 2;

-- m
select p.sexo, count(*), sum(c.valor_consulta)
from consulta c
	     join paciente p on c.codp = p.codp
group by 1;
