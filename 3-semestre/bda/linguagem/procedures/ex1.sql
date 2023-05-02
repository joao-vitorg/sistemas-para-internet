use mepoupe;

-- 2)
drop procedure sp_insere_cli;
create procedure sp_insere_cli(var_nome varchar(50),
                               var_CPF char(11),
                               var_sexo char(1),
                               var_dt_nasc date,
                               var_telefone char(15),
                               var_email varchar(100))
begin
    if (var_nome IS NOT NULL and var_CPF is not null) then
        insert into cliente(nome, CPF, sexo, dt_nasc, telefone, email)
        VALUES (var_nome, var_CPF, var_sexo, var_dt_nasc, var_telefone, var_email);
    else
        select 'FormularioNome e/ou CPF não podem ser nulo' msg;
    end if;
end;

-- 3)
create table registro_transferencia
(
    cod_transferencia int primary key auto_increment,
    cod_conta_origem  int,
    cod_conta_destino int,
    valor             numeric(9, 2),
    dt_transferencia  datetime,
    foreign key (cod_conta_origem) references cliente (cod_cliente),
    foreign key (cod_conta_destino) references cliente (cod_cliente)
);

drop procedure if exists sp_transferencia;
create procedure sp_transferencia(var_cod_origem int, var_cod_destino int, var_valor numeric(9, 2))
begin
    if (var_valor > 0 and (select cc.saldo from conta_corrente cc where var_cod_origem = cc.cod_conta) >= var_valor) then
        insert into registro_transferencia(cod_conta_origem, cod_conta_destino, valor, dt_transferencia)
        VALUES (var_cod_origem, var_cod_destino, var_valor, now());
        update conta_corrente set saldo = saldo - var_valor where var_cod_origem = cod_conta;
        update conta_corrente set saldo = saldo + var_valor where var_cod_destino = cod_conta;
    else
        select 'Saldo insuficiente' msg;
    end if;
end;

-- 3)
drop procedure if exists sp_relatorio_compra;
create procedure sp_relatorio_compra(var_dt_inicio date, var_dt_final date)
begin
    select c.nome, cc.cod_conta, sum(rd.valor_deposito) valor_total
    from cliente c
             join conta_corrente cc on c.cod_cliente = cc.cod_cliente
             join registro_deposito rd on cc.cod_conta = rd.cod_conta
    where (rd.dt_deposito between var_dt_inicio and var_dt_final)
    group by 2;
end;

-- 4)
drop procedure if exists sp_relatorio_contas;
create procedure sp_relatorio_contas(var_ano int, var_cod_relatorio int)
begin
    case
        when (var_cod_relatorio = 1) then select cc.cod_conta, month(r.dt_saque) mes, sum(r.valor_saque) total
                                          from conta_corrente cc
                                                   join registro_saque r
                                                        on cc.cod_conta = r.cod_conta
                                          where year(r.dt_saque) = var_ano
                                          group by 2;
        when (var_cod_relatorio = 2) then select cc.cod_conta, month(rd.dt_deposito) mes, sum(rd.valor_deposito) total
                                          from conta_corrente cc
                                                   join registro_deposito rd
                                                        on cc.cod_conta = rd.cod_conta
                                          where year(rd.dt_deposito) = var_ano
                                          group by 2;
        else select 'O codigo do relatorio pode ser apenas 1 ou 2' msg;
        end case;
end;
