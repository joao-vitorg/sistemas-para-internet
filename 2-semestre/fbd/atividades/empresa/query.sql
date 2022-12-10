-- Exercício 1

select cod_cargo, cod_depto, nome from funcionario where year(data_adm) = 2008;

select nome from cargo where salario between 2000 and 5000;

select nome, salario from cargo where salario >= 3000;

select * from funcionario where nome = 'Fernando Silva';

select * from funcionario where nome like '%eira %';

select * from funcionario where nome like '% %silv%';

select nome, data_adm from funcionario where nome like '%p%' or nome like '%m%';

select * from funcionario where not (nome like 'j%' or nome like 'g%');

select nome, sexo from funcionario where nome like '% silva';

select cod_depto, sigla from departamento where cod_depto in (1,2);

select cod_func, nome from funcionario where sexo != 'f' and cod_depto not in (1,3);

select cod_cargo, salario from cargo where nome in ('atendente', 'contador', 'desenvolvedor');
