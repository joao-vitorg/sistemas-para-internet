use zamazon;

-- Trigger para armazenar senha antiga e senha nova, a senha tendo menos de 20 caracteres não será alterada.
CREATE TABLE registroSenhas
(
    id_registro int(11) primary key auto_increment,
    id_cliente  int(11),
    senhaAntiga varchar(50),
    senhaNova   varchar(50)
);

delimiter $
create trigger registraSenhas
    before update
    on cliente
    for each row
begin
    case
        when (length(new.senha) < 20) then set new.senha = old.senha;
        else insert into registroSenhas values (null, OLD.id_cliente, OLD.senha, new.senha);
    end case;
end $
delimiter ;
