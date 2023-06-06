use zamazon;

-- A) Função para alterar quantidade de produtos no estoque
SET GLOBAL log_bin_trust_function_creators = 1;
DELIMITER |
CREATE FUNCTION alterarEstoqueProduto(id int(11), quantRecebida int(11)) RETURNS int(11)
BEGIN
    DECLARE novoEstoque int(11);
    SET novoEstoque = (select p.estoque from produto p where p.id_produto = id) + quantRecebida;
    update produto set estoque = novoEstoque where produto.id_produto = id;
    return novoEstoque;
END |
Delimiter ;

select alterarEstoqueProduto(1, 400);
select alterarEstoqueProduto(2, 70);
select alterarEstoqueProduto(3, -20);
select alterarEstoqueProduto(4, -300);
