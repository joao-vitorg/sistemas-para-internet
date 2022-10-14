-- Exercício 1

select f.nome, sexo, c.nome
from funcionario f
         join cargo c on c.cod_cargo = f.cod_cargo
where c.nome = 'Desenvolvedor';

select f.nome, d.sigla
from funcionario f
         join departamento d on f.cod_depto = d.cod_depto;

select f.nome, sexo, salario
from funcionario f
         join cargo c on c.cod_cargo = f.cod_cargo
where year(data_adm) = 2009;

select f.nome, data_adm, d.nome
from funcionario f
         join departamento d on f.cod_depto = d.cod_depto
where sexo = 'f';

select f.*
from funcionario f
         join departamento d on f.cod_depto = d.cod_depto
where d.nome in ('Informatica', 'Financeiro');

select f.nome, c.nome, salario, d.nome, nivel
from funcionario f
         join cargo c on f.cod_cargo = c.cod_cargo
         join departamento d on d.cod_depto = f.cod_depto
where c.nivel = 'JR'
  and year(f.data_adm) = 2008;
