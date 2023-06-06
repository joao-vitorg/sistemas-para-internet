use zamazon;

-- A) Função que transforma um produto em um JSON
drop function if exists produto_json;
CREATE FUNCTION produto_json(var_id_produto int) RETURNS json
BEGIN
    RETURN (select json_object('id_produto', id_produto, 'nome', nome, 'descricao', descricao, 'preco', preco,
                               'estoque', estoque, 'categoria_id', categoria_id, 'loja_id', loja_id)
            from produto p
            where p.id_produto = var_id_produto);
END;

select produto_json(1);
