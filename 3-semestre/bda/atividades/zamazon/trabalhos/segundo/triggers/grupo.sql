use zamazon;

-- A) Caso tente inserir um pedido, a data do cartão é conferida
delimiter $
create trigger tr_valida_pedido
    before insert
    on pedido
    for each row
BEGIN
    DECLARE erro CONDITION FOR SQLSTATE '45000';
    if ((select c.expiracao from cartao c where c.cliente_id = NEW.cliente_id) < now()) THEN
        SIGNAL erro SET MESSAGE_TEXT = 'O cartão está expirado';
    end if;
END $
delimiter ;

call insere_pedido(12, 12, 12, 1);
