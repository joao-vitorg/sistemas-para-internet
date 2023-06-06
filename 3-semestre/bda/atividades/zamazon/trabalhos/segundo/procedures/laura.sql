use zamazon;

-- Insere produtos na tabela, apenas se estiverem com dados obrigatórios
DELIMITER $$
CREATE PROCEDURE insere_produto(var_nome varchar(50), var_descricao text, var_preco numeric(9, 2), var_estoque int,
                                var_categoria_id int, var_loja_id int)
BEGIN
    if (var_nome is null) then
        select 'Nome do PRODUTO é obrigatorio' as msg;
    elseif (var_descricao is null) then
        select 'Descrição do PRODUTO é obrigatorio' as msg;
    elseif (var_preco is null) then
        select 'PRECO do PRODUTO é obrigatorio' as msg;
    elseif (var_estoque is null) then
        select 'ESTOQUE do PRODUTO é obrigatorio' as msg;
    elseif (var_categoria_id is null) then
        select 'CATEGORIA do PRODUTO é obrigatorio' as msg;
    elseif (var_loja_id is null) then
        select 'ID DA LOJA do PRODUTO é obrigatorio' as msg;
    else
        insert into produto(nome, descricao, preco, estoque, categoria_id, loja_id)
        values (var_nome, var_descricao, var_preco, var_estoque, var_categoria_id, var_loja_id);
    end if;
END $$
DELIMITER ;

call insere_produto(null, 'iPHONE 14 PRO MAX ', 7991.87, 9, 2, 3);
call insere_produto('CAMISA', null, 32.90, 12, 1, 5);
call insere_produto('BOLSA DE ACADEMIA', ' NIKE - tamanho GG ', null, 9, 2, 2);
call insere_produto('MOUSE', 'Dispositivo apontador para computador.', 200.00, null, 3, 5);
call insere_produto('CAMISA POLO', 'Roupa modelo esporte fino.', 150.00, 300, null, 2);
call insere_produto('AIRPODS', 'Fones de ouvido sem fio da Apple.', 1300.00, 400, 3, null);
call insere_produto('AIRPODS 2', 'Fones de ouvido sem fio da Apple.', 1300.00, 400, 3, 2);


-- Procedure que busca os top 3 produtos vendidos em um determinado período
DELIMITER $$
CREATE PROCEDURE Top3produtos(IN start_date DATE, IN end_date DATE)
BEGIN
    SELECT p.id_produto, p.nome, SUM(pp.quantidade) AS total_vendas
    FROM produto p
             JOIN pedido_produto pp ON p.id_produto = pp.produto_id
             JOIN pedido ped ON pp.pedido_id = ped.id_pedido
    WHERE ped.data_pedido BETWEEN start_date AND end_date
    GROUP BY p.id_produto, p.nome
    ORDER BY total_vendas DESC
    LIMIT 3;
END $$
DELIMITER ;

CALL Top3produtos('2022-01-01', '2023-03-13');


-- Procedure que lista todos os clientes com pedidos com status "PROCESSANDO"
DELIMITER $$
CREATE PROCEDURE ProdutosEmProcessamento()
BEGIN
    SELECT c.nome AS nome_cliente, p.nome AS nome_produto, ped.status_pedido AS status_pedido
    FROM cliente c
             JOIN pedido ped ON c.id_cliente = ped.cliente_id
             JOIN pedido_produto pp ON ped.id_pedido = pp.pedido_id
             JOIN produto p ON pp.produto_id = p.id_produto
    WHERE ped.status_pedido = 'PROCESSANDO';
END $$
DELIMITER ;

call ProdutosEmProcessamento();
