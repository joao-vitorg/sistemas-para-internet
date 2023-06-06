use zamazon;

-- A) Funcao que calcula o valor total de produtos que esta no carrinho do cliente.
delimiter $
create function calc_preco_total_carrinho(var_client_id int) returns numeric(9, 2)
begin
    return (select sum(p.preco * c.quantidade)
            from carrinho c
                     inner join produto p on p.id_produto = c.produto_id
            where c.cliente_id = var_client_id);
end $
delimiter ;

select calc_preco_total_carrinho(1);
