use mepoupe;

-- 1-2)
(select c.nome, cc.cod_conta, concat('Depositos: ', coalesce(sum(rd.valor_deposito), 0)) operacao
 from registro_deposito rd
          right join conta_corrente cc on cc.cod_conta = rd.cod_conta
          join cliente c on c.cod_cliente = cc.cod_cliente
 group by 1, 2)
union all
(select c.nome, cc.cod_conta, concat('Saques: ', coalesce(sum(rs.valor_saque), 0)) operacao
 from registro_saque rs
          right join conta_corrente cc on cc.cod_conta = rs.cod_conta
          join cliente c on c.cod_cliente = cc.cod_cliente
 group by 1, 2);


-- 2-A)
select cc.cod_conta, c.nome, c.telefone, c.email
from cliente c
         join conta_corrente cc on c.cod_cliente = cc.cod_cliente
where cc.cod_conta not in (select rd.cod_conta from registro_deposito rd where rd.cod_conta = cc.cod_conta and timestampdiff(month, rd.dt_deposito, now()) >= 6)
  and cc.cod_conta not in (select rs.cod_conta from registro_saque rs where rs.cod_conta = cc.cod_conta and timestampdiff(month, rs.dt_saque, now()) >= 6);


-- 2-B)
(select cc.cod_conta, year(rs.dt_saque) ano, month(rs.dt_saque) mes, coalesce(concat('Saque: ', sum(rs.valor_saque)), 'Sem registros de saque') movimento
 from conta_corrente cc
          left join registro_saque rs on cc.cod_conta = rs.cod_conta and month(rs.dt_saque) = 3
 group by 1, 2)
union all
(select cc.cod_conta,
        year(rd.dt_deposito)                                                                 ano,
        month(rd.dt_deposito)                                                                mes,
        coalesce(concat('Deposito: ', sum(rd.valor_deposito)), 'Sem registros de depositos') movimento
 from conta_corrente cc
          left join registro_deposito rd on cc.cod_conta = rd.cod_conta and month(rd.dt_deposito) = 3
 group by 1, 2);


-- 2-C)
select cc.cod_conta, c.nome, count(rs.cod_saque) qtde_saques
from cliente c
         join conta_corrente cc on c.cod_cliente = cc.cod_cliente
         left join registro_saque rs on cc.cod_conta = rs.cod_conta
group by 1;


-- 2-D)
select c.nome, c.CPF, cc.cod_conta
from cliente c
         join conta_corrente cc on c.cod_cliente = cc.cod_cliente
where cc.saldo >= 100000;


-- 3-A)
select distinct c.*
from cliente c
         join conta_corrente cc on c.cod_cliente = cc.cod_cliente
where cc.cod_conta in (select rd.cod_conta from registro_deposito rd where month(rd.dt_deposito) = 3);


-- 3-B)
select c.CPF, c.nome, c.telefone, c.email, cc.cod_cliente
from cliente c
         join conta_corrente cc on c.cod_cliente = cc.cod_cliente
where (select sum(rd.valor_deposito) from registro_deposito rd where year(rd.dt_deposito) = 2023 and rd.cod_conta = cc.cod_conta) >
      (select avg(rd.valor_deposito) from registro_deposito rd where year(rd.dt_deposito) = 2023);


-- 3-C)
select c.*
from cliente c
         join conta_corrente cc on c.cod_cliente = cc.cod_cliente
where month(cc.dt_hora_abertura) in (1, 2);


-- 3-D)
select cc.cod_cliente, cc.saldo, cc.dt_hora_abertura
from cliente c
         join conta_corrente cc on c.cod_cliente = cc.cod_cliente
where year(cc.dt_hora_abertura) = 2023
  and c.sexo = 'F';
