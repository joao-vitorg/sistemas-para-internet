USE mepoupe;

-- 1)(4,0 pontos) Crie o procedimento sp_insere_conta_corrente que irá receber como dados de entrada o  CPF de um
-- cliente  e fará a inserção na tabela Conta Corrente de uma nova conta para esse cliente. A data e hora de abertura
-- deve ser preenchida com a data e hora da inserção dos dados, o saldo deve se de R $ 50  inicialmente e o status
-- "Ativa". Validar se o cliente informado existe antes de fazer a inserção dos dados.
DROP PROCEDURE IF EXISTS sp_insere_conta_corrente;
CREATE PROCEDURE sp_insere_conta_corrente(var_cpf VARCHAR(11))
BEGIN
	DECLARE cliente_cod INT DEFAULT (SELECT cod_cliente FROM cliente c WHERE cpf = var_cpf);
	IF (cliente_cod IS NOT NULL) THEN
		INSERT INTO conta_corrente (dt_hora_abertura, saldo, status, cod_cliente)
		VALUES (NOW(), 50, 'Ativa', cliente_cod);
	ELSE
		SELECT 'CPF inexistente';
	END IF;
END;

CALL sp_insere_conta_corrente('12999786543');


-- 2) (4,0 pontos) Crie o procedimento sp_lista_anivers  que irá receber como dado de entrada o número do mês e
-- selecionar o nome, email e idade dos clientes que fazem aniversário naquele mês. Validar se o número do mês é válido.
DROP PROCEDURE IF EXISTS sp_lista_anivers;
CREATE PROCEDURE sp_lista_anivers(var_mes INT)
BEGIN
	IF (var_mes BETWEEN 1 AND 12) THEN
		(SELECT nome, email, TIMESTAMPDIFF(YEAR, dt_nasc, NOW()) idade FROM cliente c WHERE MONTH(dt_nasc) = var_mes);
	ELSE
		SELECT 'Mês invalido';
	END IF;
END;

CALL sp_lista_anivers(5);


-- 3)  (4,0 pontos) Crie a função func_tempo_conta que irá receber como dado de entrada a data de criação de uma conta e
-- irá retornar há quantos dias a conta foi criada. O retorno da função deve conter a quantidade de dias juntamente com
-- a palavra dias. Ex.: 72 dias
DROP FUNCTION IF EXISTS func_tempo_conta;
CREATE FUNCTION func_tempo_conta(var_criacao DATE) RETURNS VARCHAR(10)
BEGIN
	RETURN CONCAT(TIMESTAMPDIFF(DAY, var_criacao, NOW()), ' dias');
END;

SELECT func_tempo_conta('2020-03-15');


-- 4) (4,0 pontos) Crie o trigger tr_verifica_saldo que antes da inserção de um registro de saque em uma conta verifique
-- se a conta tem saldo suficiente. Restrição: o saque não pode deixar a conta com saldo <0.
DROP TRIGGER IF EXISTS tr_verifica_saldo;
CREATE TRIGGER tr_verifica_saldo
	BEFORE INSERT
	ON registro_saque
	FOR EACH ROW
BEGIN
	DECLARE var_saldo DECIMAL(9, 2) DEFAULT (SELECT cc.saldo FROM conta_corrente cc WHERE cc.cod_conta = new.cod_conta);
	IF (var_saldo < new.valor_saque) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Saldo insuficiente';
	END IF;
END;

INSERT INTO registro_saque (cod_conta, dt_saque, valor_saque)
VALUES (1, NOW(), 51);


-- 5) (4,0 pontos)Crie o trigger tr_valida_inativacao que antes de  atualizar o status de uma conta de "ativa" para
-- ‘Inativa’ verifique se a conta possui saldo. Caso o saldo da conta seja maior que 0(zero), retornar um erro
-- informando a necessidade de sacar o dinheiro antes da inativação da conta.
DROP TRIGGER IF EXISTS tr_valida_inativacao;
CREATE TRIGGER tr_valida_inativacao
	BEFORE UPDATE
	ON conta_corrente
	FOR EACH ROW
BEGIN
	DECLARE var_saldo DECIMAL(9, 2) DEFAULT (SELECT cc.saldo FROM conta_corrente cc WHERE cc.cod_conta = new.cod_conta);
	IF (new.status = 'Inativa' AND var_saldo > 0) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Saque o dinheiro antes de inativar a conta';
	END IF;
END;

UPDATE conta_corrente
SET status = 'Inativa'
WHERE cod_conta = 1;


-- 6) (4,0 pontos)  Crie uma função chamada func_mes_nro que receba como entrada o nome do mês e retorne o numero do mês
-- correspondente. Caso seja um nome de mês inválido, retornar -1.
DROP FUNCTION IF EXISTS func_mes_nro;
CREATE FUNCTION func_mes_nro(var_nome_mes VARCHAR(10)) RETURNS INT
BEGIN
	CASE
		WHEN (var_nome_mes = 'janeiro') THEN RETURN 1;
		WHEN (var_nome_mes = 'fevereiro') THEN RETURN 2;
		WHEN (var_nome_mes = 'março') THEN RETURN 3;
		WHEN (var_nome_mes = 'abril') THEN RETURN 4;
		WHEN (var_nome_mes = 'maio') THEN RETURN 5;
		WHEN (var_nome_mes = 'junho') THEN RETURN 6;
		WHEN (var_nome_mes = 'julho') THEN RETURN 7;
		WHEN (var_nome_mes = 'agosto') THEN RETURN 8;
		WHEN (var_nome_mes = 'setembro') THEN RETURN 9;
		WHEN (var_nome_mes = 'outubro') THEN RETURN 10;
		WHEN (var_nome_mes = 'novembro') THEN RETURN 11;
		WHEN (var_nome_mes = 'dezembro') THEN RETURN 12;
		ELSE RETURN -1;
	END CASE;
END;

SELECT func_mes_nro('outubro');
