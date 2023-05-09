use mepoupe;

-- 1)
drop function if exists to_br_date;
CREATE FUNCTION to_br_date(data date) RETURNS varchar(10)
BEGIN
	RETURN concat_ws('/', day(data), month(data), year(data));
END;

select rs.cod_conta, to_br_date(rs.dt_saque) dt_saque_br, rs.valor_saque
from registro_saque rs;

-- 2)
drop function if exists date_to_day;
CREATE FUNCTION date_to_day(data date) RETURNS varchar(15)
BEGIN
	declare dia_semana int default weekday(data);
	case
		when (dia_semana = 0) then return 'segunda-feira';
		when (dia_semana = 1) then return 'terça-feira';
		when (dia_semana = 2) then return 'quarta-feira';
		when (dia_semana = 3) then return 'quinta-feira';
		when (dia_semana = 4) then return 'sexta-feira';
		when (dia_semana = 5) then return 'sabado';
		when (dia_semana = 6) then return 'domingo';
	end case;
END;

select date_to_day(now()) dia_extenso;

-- 3)
drop function if exists formatar_cpf;
CREATE FUNCTION formatar_cpf(cpf char(11)) RETURNS varchar(14)
BEGIN
	RETURN concat(concat_ws('.', substring(cpf, 1, 3), substring(cpf, 4, 3), substring(cpf, 7, 3)), '-',
	              substring(cpf, 10, 2));
END;

select formatar_cpf('12345678901');

-- 4)
drop procedure if exists relatorio_media_dias;
create procedure relatorio_media_dias(var_ano int, var_mes int)
begin
	select format(avg(valor_deposito), 2) media_deposito, date_to_day(dt_deposito) dia
	from registro_deposito r
	where year(dt_deposito) = var_ano
	  and (var_mes is null or month(dt_deposito) = var_mes)
	group by 2;
end;

call relatorio_media_dias(2023, null);
