use zamazon;

-- A) Procedimento que insere um pedido, verificando se o cliente, endereço e cartão são válidos e se o endereço e
-- cartão pertencem ao cliente
drop procedure if exists insere_pedido;
create procedure insere_pedido(var_cliente_id int, var_endereco_id int, var_cartao_id int, var_n_parcelas int)
begin
    case
        when (var_n_parcelas is null or var_n_parcelas <= 0)
            then select 'Parcela não pode ser nulo ou menor que 0' as msg;
        when (var_cliente_id is null) then select 'Cliente não pode ser nulo' as msg;
        when (var_endereco_id is null) then select 'Endereço não pode ser nulo' as msg;
        when (var_cartao_id is null) then select 'Cartão não pode ser nulo' as msg;
        when (var_endereco_id not in (select id_endereco from endereco e where e.cliente_id = var_cliente_id))
            then select 'O endereço deve ser no nome do cliente' as msg;
        when (var_cartao_id not in (select id_cartao from cartao c where c.cliente_id = var_cliente_id))
            then select 'O cartão deve ser no nome do cliente' as msg;
        else insert into pedido(data_pedido, status_pedido, n_parcelas, preco_total, frete_total,
                                cliente_id, endereco_id, cartao_id)
             VALUES (now(), 'Aguardando pagamento', var_n_parcelas, 0, 0, var_cliente_id, var_endereco_id,
                     var_cartao_id);
    end case;
end;

call insere_pedido(1, 1, 1, 1);


-- B) Procedimento que gerar um relatório de vendas de uma loja, com o total de vendas por ano e mês
drop procedure if exists relatorio_vendas;
create procedure relatorio_vendas(var_id_loja int)
begin
    case
        when (var_id_loja is null) then select 'Id da loja não pode ser nulo' as msg;
        else (select ano, mes, qtd_vendas, ganho_total, total_frete from vw_vendas where id_loja = var_id_loja)
             union all
             (select ano, 'Total', sum(qtd_vendas), sum(ganho_total), sum(total_frete)
              from vw_vendas vv
              where id_loja = var_id_loja
              group by ano);
    end case;
end;

call relatorio_vendas(2);


-- C) Procedimento que gera um relatório de entregas de uma loja.
drop procedure if exists relatorio_entregas;
create procedure relatorio_entregas(var_id_loja int)
begin
    case
        when (var_id_loja is null) then select 'Id da loja não pode ser nulo' as msg;
        else select p.data_pedido,
                    timestampdiff(day, p.data_pedido, now()) dias_decorrido,
                    c.nome,
                    e.cod_postal,
                    e.endereco,
                    p2.nome                                  produto,
                    pp.preco,
                    pp.frete
             from pedido p
                      join pedido_produto pp on p.id_pedido = pp.pedido_id
                      join produto p2 on p2.id_produto = pp.produto_id
                      join endereco e on e.id_endereco = p.endereco_id
                      join cliente c on c.id_cliente = p.cliente_id
             where p.status_pedido = 'Em transporte'
               and p2.loja_id = var_id_loja;
    end case;
end;

call relatorio_entregas(2);
