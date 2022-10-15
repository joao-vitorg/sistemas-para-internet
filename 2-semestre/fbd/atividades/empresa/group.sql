select d.nome, min(c.salario), max(c.salario)
from funcionario f
         join cargo c on c.cod_cargo = f.cod_cargo
         join departamento d on d.cod_depto = f.cod_depto
group by 1
order by 1;

select year(f.data_adm), month(f.data_adm), count(*)
from funcionario f
group by 1, 2;

select c.nome, count(c.nivel)
from funcionario f
         join empresa.cargo c on c.cod_cargo = f.cod_cargo
group by 1
order by 1;

select d.nome, sum(c.salario)
from funcionario f
         join cargo c on c.cod_cargo = f.cod_cargo
         join departamento d on d.cod_depto = f.cod_depto
group by 1
order by 2 desc;

select d.nome, min(f.data_adm), max(f.data_adm)
from funcionario f
         join departamento d on d.cod_depto = f.cod_depto
group by 1;

select d.nome, f.sexo, count(*)
from funcionario f
         join cargo c on c.cod_cargo = f.cod_cargo
         join departamento d on d.cod_depto = f.cod_depto
group by 1, 2;

select d.nome, sum(c.salario)
from funcionario f
         join cargo c on c.cod_cargo = f.cod_cargo
         join departamento d on d.cod_depto = f.cod_depto
group by 1
order by 1;

select c.nome, c.nivel, sum(c.salario)
from funcionario f
         join cargo c on c.cod_cargo = f.cod_cargo
         join departamento d on d.cod_depto = f.cod_depto
where d.nome = 'informática'
group by 1, 2;
