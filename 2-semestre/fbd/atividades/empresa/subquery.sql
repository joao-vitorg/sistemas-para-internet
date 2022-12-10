use empresa;

-- EX1

-- a) Listar o nome e sexo dos funcionarios que ganham mais que R$ 1400
select f.nome, f.sexo
from funcionario f
where f.cod_cargo in (select c.cod_cargo from cargo c where c.salario > 1400);

-- b) Listar as informações dos cargos que possuem ao menos um funcionário
select c.*
from cargo c
where c.cod_cargo in (select f.cod_cargo from funcionario f);

-- c) Listar as informações dos cargos que não possuem funcionários
select c.*
from cargo c
where c.cod_cargo not in (select cod_cargo from funcionario f);

-- d) Listar o nome, data de admissão e sexo dos funcionários do departamento Financeiro
select f.nome, f.data_adm, f.sexo
from funcionario f
where f.cod_depto in (select d.cod_depto from departamento d where d.sigla = 'FIN');

-- e) Listar os dados dos funcionários do sexo masculino que foram contratados antes da Janete Rosa
select *
from funcionario f
where f.sexo = 'M'
  and f.data_adm < (select f2.data_adm from funcionario f2 where f2.nome = 'Janete Rosa');

-- f) Listar o nome dos departamentos que não fizeram contratações no ano de 2008
select d.nome
from departamento d
where d.cod_depto not in (select f.cod_depto from funcionario f where year(f.data_adm) = 2008);

-- g) Listar as informações do cargo de maior salário
select *
from cargo c
where c.salario = (select max(c2.salario) from cargo c2);

-- h) Para funcionário mais antigo da empresa listar: nome do funcionário, o  nome do cargo e nível, e nome do seu departamento
select f.nome,
       (select c.nome from cargo c where f.cod_cargo = c.cod_cargo),
       (select c.nivel from cargo c where f.cod_cargo = c.cod_cargo),
       (select d.nome from departamento d where f.cod_depto = d.cod_depto)
from funcionario f
where f.data_adm = (select max(f2.data_adm) from funcionario f2);

-- i) Listar os dados de todos os funcionários da empresa, exceto do que foi contratado mais recentemente
select *
from funcionario f
where f.data_adm <> (select min(f2.data_adm) from funcionario f2);

-- j) Listar os dados dos departamentos que possuem funcionárias do sexo feminino
select *
from departamento d
where d.cod_depto in (select f.cod_depto from funcionario f where f.sexo = 'F');

-- k) Listar o nome e nível dos cargos dos funcionários do sexo masculino
select c.nome, c.nivel
from cargo c
where c.cod_cargo in (select f.cod_cargo from funcionario f where f.sexo = 'M');

-- l) Listar os dados dos cargos que possuem funcionários, mas não possuem funcionários do sexo feminino
select *
from cargo c
where c.cod_cargo in (select f.cod_cargo from funcionario f)
  and c.cod_cargo not in (select f2.cod_cargo from funcionario f2 where f2.sexo = 'F');
