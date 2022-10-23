use clinica;

-- a
select sum(c.valor_consulta)
from consulta c
	     join medico m on m.codm = c.codm
where m.sexo = 'f'
  and c.dt_consulta like '2017-07%';

-- b
select max(c.valor_consulta), min(c.valor_consulta), avg(c.valor_consulta)
from consulta c
where year(c.dt_consulta) = 2017
  and month(c.dt_consulta) in (6, 7);

-- c
select count(*)
from consulta c
	     join paciente p on p.codp = c.codp
where p.problema = 'Hipertensao';

-- d
select count(*)
from consulta c
	     join medico m on c.codm = m.codm
where year(c.dt_consulta) = 2017
  and m.especialidade = 'Neurologista';

-- e
select sum(c.valor_consulta)
from consulta c
	     join medico m on m.codm = c.codm
where m.nomem = 'Maria Jose'
  and c.dt_consulta like '2017-07%';

-- f
select p.nomep, m.nomem, c.dt_consulta, c.hora_consulta
from consulta c
	     join paciente p on p.codp = c.codp
	     join medico m on m.codm = c.codm
where c.dt_consulta like '2017-06%';
