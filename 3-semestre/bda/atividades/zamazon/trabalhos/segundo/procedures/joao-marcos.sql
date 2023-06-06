use zamazon;

-- A) Inserir categoria
DELIMITER $
CREATE PROCEDURE insere_categoria(var_id_categoria int, var_descricao varchar(50))
BEGIN
    case
        when (var_descricao is null) then select 'Adicione descrição' as Erro;
        else insert into categoria (id_categoria, descricao) VALUES (var_id_categoria, var_descricao);
    end case;
END $
DELIMITER ;

call insere_categoria(null, 'Pet');
call insere_categoria(null, 'Informática');
call insere_categoria(null, 'Telefonia');
call insere_categoria(null, null);


-- b) Listar quantidade de itens no carrinho que ainda nao foram comprados informando a região através de código
-- de área DDD ex (34,11)
DELIMITER $
CREATE PROCEDURE listar_Carrinho(ddd varchar(2))
BEGIN
    case
        when (ddd is null) then select 'Insira o DDD' as Erro;
        when (ddd not in (SELECT LEFT(c.telefone, 2)
                          from cliente c
                                   inner join carrinho cr on c.id_cliente = cr.cliente_id
                          where LEFT(c.telefone, 2) = ddd)) then select 'Nenhum registro nessa região' as Erro;
        else select c.nome, c.telefone, c.email, sum(cr.quantidade) as qtdItensCarrinho
             from cliente c
                      inner join carrinho cr on c.id_cliente = cr.cliente_id
             where (SELECT LEFT(c.telefone, 2)) = ddd
             group by c.nome
             order by qtdItensCarrinho desc;
    end case;
END $
DELIMITER ;

call listar_Carrinho(11);
call listar_Carrinho(34);
call listar_Carrinho(00);
call listar_Carrinho(null);


-- c) Procedure para listar cliente com cartão vencendo a partir de uma data informada, sendo listada datas mais
-- proximas do vencimento da data informada, será listado nome, email e quantidade de produtos no carrinho e quantidade
-- de dias que faltam para o cartão expirar a partir de hoje.
DELIMITER $
CREATE PROCEDURE produtos_carrinho(dtCartao date)
BEGIN
    select c.nome,
           c.email,
           sum(cr.quantidade)                      as somaItensCarrinho,
           ct.expiracao,
           timestampdiff(day, now(), ct.expiracao) as DiasExpiracao
    from cliente c
             inner join carrinho cr on c.id_cliente = cr.cliente_id
             inner join cartao ct on c.id_cliente = ct.cliente_id
    where ct.expiracao >= dtCartao
    group by c.nome
    order by ct.expiracao;
END $
DELIMITER ;

call produtos_carrinho('2030-02-13');
call produtos_carrinho('2025-02-13');
call produtos_carrinho('2023-02-13');
