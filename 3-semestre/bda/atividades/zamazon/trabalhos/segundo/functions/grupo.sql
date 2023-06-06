use zamazon;

-- A) Funcao que calcula o valor total de produtos em estoque para controle financeiro.
delimiter $
create function calc_vlr_total_produtos_em_estoque(var_produto_id int) returns numeric(9, 2)
begin
    return (select sum(preco * estoque) from produto where id_produto = var_produto_id);
end $
delimiter ;

select calc_vlr_total_produtos_em_estoque(2);
