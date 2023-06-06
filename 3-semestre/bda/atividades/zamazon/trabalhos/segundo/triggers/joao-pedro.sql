use zamazon;

-- LETRA A) Trigger que valida o status do pedido que esta sendo atualizado, caso seja para Entregue deve preencher uma
-- data valida no campo data_entrega.
delimiter $
create trigger tr_valida_status_pedido
    before update
    on pedido
    for each row
BEGIN
    DECLARE erro CONDITION FOR SQLSTATE '45000';

    if (new.status_pedido not in ('Processando', 'Aguardando pagamento', 'Em transporte', 'Entregue')) THEN
        SIGNAL erro SET MESSAGE_TEXT = 'Status do pedido invalido!';
    else
        if (new.status_pedido = 'Entregue' AND new.data_entrega is null) then
            SIGNAL erro SET MESSAGE_TEXT =
                    'Para colocar o pedido como entregue é obrigatorio preencher a data de entrega!';
        else
            if (new.status_pedido = 'Entregue' AND new.data_entrega < old.data_pedido) then
                SIGNAL erro SET MESSAGE_TEXT =
                        'A data de entrega do pedido não pode ser menor que a data de criação do pedido!';
            end if;
        end if;
    end if;
END $
delimiter ;

update pedido
set status_pedido = 'aaa'
where id_pedido = 1;

update pedido
set status_pedido = 'Entregue',
    data_entrega  = '2022-07-10'
where id_pedido = 1;
