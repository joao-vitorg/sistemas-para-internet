select max(c.salario)
from funcionario f
         join departamento d on d.cod_depto = f.cod_depto
         join cargo c on c.cod_cargo = f.cod_cargo
where d.nome = 'Pessoal';

select sum(c.salario)
from funcionario f
         join departamento d on d.cod_depto = f.cod_depto
         join cargo c on c.cod_cargo = f.cod_cargo
where d.nome = 'Financeiro';

select count(*)
from funcionario f
         join departamento d on d.cod_depto = f.cod_depto
where d.nome = 'Informática';

select min(c.salario)
from funcionario f
         join departamento d on d.cod_depto = f.cod_depto
         join cargo c on c.cod_cargo = f.cod_cargo
where d.nome = 'Informática';

select max(c.salario), min(c.salario), avg(c.salario), sum(c.salario)
from funcionario f
         join departamento d on d.cod_depto = f.cod_depto
         join cargo c on c.cod_cargo = f.cod_cargo
where d.nome = 'Informática';

select count(*)
from funcionario f
         join departamento d on d.cod_depto = f.cod_depto
where d.nome in ('Financeiro', 'Pessoal')
  and f.sexo = 'F';

select avg(c.salario)
from funcionario f
         join cargo c on c.cod_cargo = f.cod_cargo
where year(f.data_adm) = 2008
  and month(f.data_adm) <= 6;

select *
from funcionario f
         join cargo c on c.cod_cargo = f.cod_cargo
where c.salario <= 2000;
