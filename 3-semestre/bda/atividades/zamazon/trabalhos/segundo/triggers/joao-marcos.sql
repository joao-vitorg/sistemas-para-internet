use zamazon;

-- 3) Trigger para registrar data e quantidade do produto antes e após atualização do estoque, caso retirada de produto
-- seja maior que quantidade em estoque não faz nada.
CREATE TABLE atualizacaoEstoque
(
    id_registro   int(11) primary key auto_increment,
    id_produto    int(11),
    nome          varchar(50),
    estoqueAntigo int(11),
    novoEstoque   int(11),
    dataChegada   date
);

delimiter $
create trigger registraEstoque
    before update
    on produto
    for each row
begin
    case
        when (new.estoque < 0) then set new.estoque = old.estoque;
        else insert into atualizacaoEstoque values (null, OLD.id_produto, OLD.nome, OLD.estoque, NEW.estoque, now());
    end case;
end $
delimiter ;
