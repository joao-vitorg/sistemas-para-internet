use clinica;

-- a) Insira ao menos 3 registros de consultas em datas futuras neste ano.
insert into consulta (codm, codp, dt_consulta, hora_consulta, valor_consulta)
values (1, 2, '2022-12-20', '16:00:00', 150.00),
       (3, 1, '2022-12-21', '14:00:00', 180.00),
       (3, 1, '2022-12-22', '14:00:00', 180.00);

-- b) Altere a data das consultas da médica Maria Jose do dia 23/07/2017 para o dia 13/08/2017
update consulta
set dt_consulta = '2017-08-13'
where dt_consulta = '2017-07-23'
  and codm = (select codm from medico m where m.nomem = 'Maria Jose');

-- c) Crie uma nova tabela com as informações do nome, data de nascimento e sexo dos pacientes que tem problema cardíaco
create table pacienteCardiaco
(
    nome    varchar(250),
    dt_nasc date,
    sexo    char(1)
);
insert into pacienteCardiaco (nome, dt_nasc, sexo)
select p.nomep, p.dt_nasc, p.sexo
from paciente p
where p.problema = 'Cardiaco';

-- d) Todas as consultas desse ano deverão ser reajustadas em 5%, dê o comando SQL que faça essa ação.
update consulta
set valor_consulta = valor_consulta * 1.05
where year(dt_consulta) = 2022;

-- e) Atualize a data e o horário da consulta do paciente Maria do Carmo
-- do dia 20/07/2017 as 15:00hs para o dia 22/07/2017 as 17:00hs.
update consulta
set hora_consulta = '17:00:00',
    dt_consulta   = '2017-07-22'
where hora_consulta = '15:00:00'
  and dt_consulta = '2017-07-20'
  and codp = (select p.codp from paciente p where p.nomep = 'Maria do Carmo');

-- f) Crie uma nova tabela DadosConsultas2017_1 com as informações do nome do medico, nome do paciente, data e hora das
-- consultas de todas as consultas do primeiro semestre do ano de 2017
create table DadosConsultas2017_1
(
    nomem         varchar(250),
    nomep         varchar(250),
    dt_consulta   date,
    hora_consulta time
);
insert into DadosConsultas2017_1 (nomem, nomep, dt_consulta, hora_consulta)
select (select nomem from medico m where c.codm = m.codm),
       (select nomep from paciente p where c.codp = p.codp),
       c.dt_consulta,
       c.hora_consulta
from consulta c
where year(c.dt_consulta) = 2017
  and month(c.dt_consulta) <= 6;

-- g) Apague da tabela DadosConsultas2017_1 os dados das consultas do mês de junho
delete
FROM DadosConsultas2017_1
where month(dt_consulta) = 6;

-- h) O médico Marcos Paulo não poderá atender as consultas marcadas entre os dias 17/07/2017 e 22/07/2017,
-- dessa forma as consultas registradas para esse período e para esse médico devem ser excluídas.
delete
from consulta
where codm = (select m.codm from medico m where m.nomem = 'Marcos Paulo')
  and dt_consulta between '2017-07-17' and '2017-07-22';
