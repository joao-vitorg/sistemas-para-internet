use zamazon;

-- A) Insere Tabela cliente
DELIMITER $$
CREATE PROCEDURE insere_cliente(var_email varchar(50), var_nome varchar(50), var_senha varchar(50),
                                var_telefone varchar(15), var_cpf varchar(15), var_dt_nascimento date, var_sexo char(1))
BEGIN
    if (var_email is null) then
        select 'Email é obrigatorio' as msg;
    elseif (var_nome is null) then
        select 'Nome é obrigatorio' as msg;
    elseif (var_senha is null) then
        select 'Senha é obrigatorio' as msg;
    elseif (var_telefone is null) then
        select 'Telefone é obrigatorio' as msg;
    elseif (var_cpf is null) then
        select 'CPF é obrigatorio' as msg;
    elseif (var_dt_nascimento is null) then
        select 'Data de nascimento é obrigatorio' as msg;
    elseif (var_sexo is null) then
        select 'Sexo é obrigatorio' as msg;
    else
        insert into cliente(email, nome, senha, telefone, cpf, dt_nascimento, sexo)
        values (var_email, var_nome, var_senha, var_telefone, var_cpf, var_dt_nascimento, var_sexo);
    end if;
END $$
DELIMITER ;

call insere_cliente(null, 'Marcos Paulo', 'senha123', '34992749333', '333.222.444-11', '2000-01-10', 'M');
call insere_cliente('marcospaulo@mail.com', null, 'senha123', '34992749333', '333.222.444-11', '2000-01-10', 'M');
call insere_cliente('marcospaulo@mail.com', 'Marcos Paulo', null, '34992749333', '333.222.444-11', '2000-01-10', 'M');
call insere_cliente('marcospaulo@mail.com', 'Marcos Paulo', 'senha123', null, '333.222.444-11', '2000-01-10', 'M');
call insere_cliente('marcospaulo@mail.com', 'Marcos Paulo', 'senha123', '34992749333', null, '2000-01-10', 'M');
call insere_cliente('marcospaulo@mail.com', 'Marcos Paulo', 'senha123', '34992749333', '333.222.444-11', null, 'M');
call insere_cliente('marcospaulo@mail.com', 'Marcos Paulo', 'senha123', '34992749333', '333.222.444-11', '2000-01-10',
                    null);
call insere_cliente('marcospaulo@mail.com', 'Marcos Paulo', 'senha123', '34992749333', '333.222.444-11', '2000-01-10',
                    'M');


-- B) Procedure que busca os top 3 clientes que gastaram mais em um determinado periodo.
DELIMITER $$
CREATE PROCEDURE busca_cliente_que_gastaram_mais_em_um_periodo(data_inicial date, data_final date)
BEGIN
    if (data_final <= data_inicial) then
        SELECT 'Data inicial nao pode ser menor que a data final' AS MSG;
    else
        select c.nome, c.email, sum(p.preco_total) as valor_gasto_total
        from cliente c
                 inner join pedido p on p.cliente_id = c.id_cliente
        where p.data_pedido BETWEEN data_inicial and data_final
        group by cliente_id
        order by 3 desc
        limit 3;
    end if;
END $$
DELIMITER ;

call busca_cliente_que_gastaram_mais_em_um_periodo('2023-04-01', '2023-03-01');
call busca_cliente_que_gastaram_mais_em_um_periodo('2023-03-01', '2023-04-01');


-- C) Procedure que lista todos os dados do cliente (sem a senha), o endereço formato (logadouro+cep) desde que possuam
-- uma idade >= a informada.
DELIMITER $$
CREATE PROCEDURE lista_cliente_endereco(idade int)
BEGIN
    if (idade <= 0) then
        SELECT 'Idade nao pode ser menor ou igual a 0' as msg;
    else
        select id_cliente,
               email,
               nome,
               telefone,
               cpf,
               dt_nascimento,
               sexo,
               concat(e.endereco, '. CEP: ', e.cod_postal) as endereco
        from cliente c
                 inner join endereco e on e.cliente_id = c.id_cliente
        where (year(CURRENT_DATE()) - year(c.dt_nascimento)) >= idade;
    end if;
END $$
DELIMITER ;

call lista_cliente_endereco(0);
call lista_cliente_endereco(25);
