use zamazon;

-- A) Funçao para alteraçao de senha validando nome, cpf e data de nascimento
SET GLOBAL log_bin_trust_function_creators = 1;

drop function if exists alterarSenha;
DELIMITER |
CREATE FUNCTION alterarSenha(var_id_cliente INT(11), nome VARCHAR(50), cpf VARCHAR(15), dt_nascimento DATE,
                             nova_senha VARCHAR(50)) RETURNS VARCHAR(50)
BEGIN
    DECLARE novaSenha VARCHAR(50);
    IF (nome != (SELECT cliente.nome FROM cliente WHERE cliente.id_cliente = var_id_cliente)) THEN
        RETURN 'Dados não conferem';
    END IF;
    IF (cpf != (SELECT cliente.cpf FROM cliente WHERE cliente.id_cliente = var_id_cliente)) THEN
        RETURN 'Dados não conferem';
    END IF;
    IF (dt_nascimento != (SELECT cliente.dt_nascimento FROM cliente WHERE cliente.id_cliente = var_id_cliente)) THEN
        RETURN 'Dados não conferem';
    END IF;
    SET novaSenha = md5(nova_senha);
    UPDATE cliente SET senha = novaSenha WHERE cliente.id_cliente = var_id_cliente;
    RETURN novaSenha;
END |
DELIMITER ;

select alterarSenha(1, 'X', '222.222.222-22', '2001-04-23', 'KKK');
select alterarSenha(2, 'Antônio Cardoso Medeiros', '123.456.789-11', '1998-02-11', 'JHASA');
select alterarSenha(3, 'Vanderlei', '1222', '1998-02-11', 'ALOU');
select alterarSenha(4, 'Laura Ribeiro Mathias', '444.444.444-44', '1976-07-13', '43321223');
