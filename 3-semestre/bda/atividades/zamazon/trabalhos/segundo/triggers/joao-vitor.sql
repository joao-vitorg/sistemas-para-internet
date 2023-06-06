use zamazon;

-- A) Triggers para atualizar o preço total do pedido e o frete
drop trigger if exists tr_pedido_produto;
create trigger tr_pedido_produto
    after insert
    on pedido_produto
    for each row
begin
    update pedido
    set preco_total = preco_total + (NEW.preco * new.quantidade),
        frete       = frete + NEW.frete
    where id_pedido = new.pedido_id;
end;

insert into pedido_produto (pedido_id, produto_id, preco, quantidade, frete)
values (1, 1, 3000, 2, 30);
