use mepoupe;

-- 1)
drop trigger if exists tr_red_client;
create trigger tr_red_client
	after insert
	on registro_saque
	for each row
begin
	declare novo_saldo decimal(9, 2);
	set novo_saldo = (select cc.saldo from conta_corrente cc where cc.cod_conta = new.cod_conta) - new.valor_saque;

	if (novo_saldo < -200) then
		signal sqlstate '45000' set message_text = 'Acabou o credito';
	end if;

	update conta_corrente set saldo = novo_saldo where cod_cliente = new.cod_conta;

	if (novo_saldo < 0 and
	    new.cod_conta not in (select trc.cod_conta from tb_red_client trc where trc.dt_saiu is NULL)) then
		insert into tb_red_client (cod_cliente, nome, cpf, cod_conta)
		select c.cod_cliente, c.nome, c.cpf, cc.cod_conta
		from cliente c
			     join conta_corrente cc on cc.cod_cliente = c.cod_cliente
		where new.cod_conta = cc.cod_conta;
	end if;
end;

insert into registro_saque (cod_conta, dt_saque, valor_saque)
values (1, now(), 150);

insert into registro_saque (cod_conta, dt_saque, valor_saque)
values (1, now(), 51);

-- 2)
drop function if exists func_calcula_valor_taxa;
create function func_calcula_valor_taxa(var_inicio date, var_fim date) returns decimal(9, 2)
begin
	return timestampdiff(day, var_inicio, var_fim) * 2.5;
end;

select func_calcula_valor_taxa('2020-03-10', null);

-- 3)
drop trigger if exists tr_redout_client;
create trigger tr_redout_client
	after insert
	on registro_deposito
	for each row
begin
	declare novo_saldo decimal(9, 2);
	set novo_saldo = ((select cc.saldo from conta_corrente cc where cc.cod_conta = new.cod_conta) + new.valor_deposito);

	update conta_corrente set saldo = novo_saldo where cod_cliente = new.cod_conta;

	if (new.cod_conta in (select trc.cod_conta from tb_red_client trc where trc.dt_saiu is null) and
	    novo_saldo > 0) then
		update tb_red_client trc
		set dt_saiu    = now(),
		    valor_taxa = func_calcula_valor_taxa(trc.dt_entrou, now())
		where trc.cod_conta = new.cod_conta;
	end if;
end;

insert into registro_saque (cod_conta, dt_saque, valor_saque)
values (1, now(), 150);

insert into registro_deposito(cod_conta, dt_deposito, valor_deposito)
VALUES (1, now(), 200);
