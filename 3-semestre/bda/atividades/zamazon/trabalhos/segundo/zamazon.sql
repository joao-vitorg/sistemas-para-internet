-- =========================================== CRIAÇÃO DO BANCO ===========================================
drop database if exists zamazon;
create database zamazon;
use zamazon;

create table loja
(
    id_loja  int         not null auto_increment primary key,
    cnpj     varchar(18) not null unique,
    nome     varchar(50) not null,
    telefone varchar(15) not null
);

create table categoria
(
    id_categoria int         not null primary key auto_increment,
    descricao    varchar(50) not null
);

create table produto
(
    id_produto   int           not null primary key auto_increment,
    nome         varchar(50)   not null,
    descricao    text          not null,
    preco        numeric(9, 2) not null,
    estoque      int           not null,
    categoria_id int           not null,
    loja_id      int           not null,
    foreign key (categoria_id) references categoria (id_categoria),
    foreign key (loja_id) references loja (id_loja)
);

create table cliente
(
    id_cliente    int         not null primary key auto_increment,
    email         varchar(50) not null unique,
    nome          varchar(50) not null,
    senha         varchar(50) not null,
    telefone      varchar(15) not null,
    cpf           varchar(15) not null unique,
    dt_nascimento date        not null,
    sexo          char        not null
);

create table endereco
(
    id_endereco int         not null primary key auto_increment,
    cod_postal  varchar(9)  not null,
    endereco    varchar(50) not null,
    cliente_id  int         not null,
    foreign key (cliente_id) references cliente (id_cliente)
);

create table cartao
(
    id_cartao  int         not null primary key auto_increment,
    numero     varchar(16) not null,
    nome       varchar(50) not null,
    expiracao  date        not null,
    cliente_id int         not null,
    foreign key (cliente_id) references cliente (id_cliente)
);

create table pedido
(
    id_pedido     int           not null primary key auto_increment,
    data_pedido   date          not null,
    status_pedido varchar(100)  not null,
    data_entrega  date,
    n_parcelas    int           not null,
    preco_total   numeric(9, 2) not null,
    frete_total   numeric(9, 2) not null,
    cliente_id    int           not null,
    endereco_id   int           not null,
    cartao_id     int           not null,
    foreign key (cliente_id) references cliente (id_cliente),
    foreign key (endereco_id) references endereco (id_endereco),
    foreign key (cartao_id) references cartao (id_cartao)
);

create table pedido_produto
(
    id_pedido_produto int           not null primary key auto_increment,
    pedido_id         int           not null,
    produto_id        int           not null,
    preco             numeric(9, 2) not null,
    quantidade        int           not null,
    frete             numeric(9, 2) not null,
    unique (pedido_id, produto_id),
    foreign key (pedido_id) references pedido (id_pedido),
    foreign key (produto_id) references produto (id_produto)
);

create table carrinho
(
    id_carrinho int not null primary key auto_increment,
    cliente_id  int not null,
    produto_id  int not null,
    quantidade  int not null,
    unique (cliente_id, produto_id),
    foreign key (cliente_id) REFERENCES cliente (id_cliente),
    foreign key (produto_id) REFERENCES produto (id_produto)
);

create table comentario
(
    id_comentario   int          not null primary key auto_increment,
    cliente_id      int          not null,
    produto_id      int          not null,
    comentario      varchar(250) not null,
    avaliacao       int          not null,
    data_comentario date         not null,
    unique (cliente_id, produto_id),
    foreign key (cliente_id) REFERENCES cliente (id_cliente),
    foreign key (produto_id) REFERENCES produto (id_produto)
);

create view vw_vendas as
select l.id_loja,
       l.nome,
       year(p2.data_pedido)          ano,
       month(p2.data_pedido)         mes,
       count(*)                      qtd_vendas,
       sum(pp.preco * pp.quantidade) ganho_total,
       sum(pp.frete)                 total_frete
from loja l
         join produto p on l.id_loja = p.loja_id
         join pedido_produto pp on p.id_produto = pp.produto_id
         join pedido p2 on pp.pedido_id = p2.id_pedido
group by 1, 3, 4;

insert into loja (cnpj, nome, telefone)
VALUES ('13.754.783/4231-42', 'Apple', '11239835679'),
       ('17.754.783/0231-12', 'Nike', '3499372391'),
       ('15.444.775/0301-12', 'Samsung', '3499372391'),
       ('16.444.737/0401-12', 'Sony', '3499372391'),
       ('17.444.737/0401-12', 'Logitech', '3499375639');

insert into categoria(descricao)
values ('Eletrônico'),
       ('Roupa'),
       ('Acessório'),
       ('Áudio'),
       ('Vídeo');

insert into produto (nome, descricao, preco, estoque, categoria_id, loja_id)
values ('Iphone 14', 'Novo smartphone da Apple.', 6500.00, 500, 1, 1),
       ('Camiseta', 'Roupa casual confortável.', 100.00, 300, 2, 2),
       ('Galaxy S20', 'Smartphone premium da Samsung.', 2000.00, 600, 1, 3),
       ('AirPods', 'Fones de ouvido sem fio da Apple.', 1300.00, 400, 3, 1),
       ('Headset', 'Fones de ouvido com microfone.', 400.00, 300, 4, 4),
       ('Mouse', 'Dispositivo apontador para computador.', 200.00, 200, 3, 5),
       ('Teclado', 'Dispositivo para entrada de texto.', 300.00, 100, 3, 5),
       ('Monitor', 'Tela de exibição para computador.', 1000.00, 500, 5, 3),
       ('Notebook', 'Computador portátil.', 3000.00, 300, 3, 3),
       ('Smart TV', 'TV com acesso à internet.', 2000.00, 200, 5, 3),
       ('Camiseta polo', 'Roupa modelo esporte fino.', 150.00, 300, 2, 2);

insert into cliente (email, nome, senha, telefone, cpf, dt_nascimento, sexo)
values ('luiz@gmail.com', 'Luiz Fernando Barbosa', '0cc175b9c0f1b6a831c399e269772661', '34992749276', '222.222.222-22',
        '2001-04-23', 'M'),
       ('antonio@gmail.com', 'Antônio Cardoso Medeiros', '92eb5ffee6ae2fec3ad71c777531578f', '11392759573',
        '123.456.789-11', '1998-02-11', 'M'),
       ('Lucas@gmail.com', 'Lucas Souza Santos', '4a8a08f09d37b73795649038408b5f33', '11993758316', '333.333.333-33',
        '1998-05-15', 'M'),
       ('laura@gmail.com', 'Laura Ribeiro Mathias', '8277e0910d750195b448797616e091ad', '51993857391', '444.444.444-44',
        '1976-07-13', 'F'),
       ('marcos@gmail.com', 'Marcos Silva Vieira', '1679091c5a880faf6fb5e6087eb1b2dc', '11993937313', '555.555.555-55',
        '1965-09-10', 'M'),
       ('scottmichael@gmail.com', 'Michael Scott', '3b5d5c3712955042212316173ccf37be', '38992723376', '321.222.321-22',
        '2002-03-11', 'M'),
       ('carolfs@gmail.com', 'Carolina Ferreira Souza', '60b725f10c9c85c70d97880dfe8191b3', '14392982573',
        '123.877.789-66', '1993-01-12', 'F'),
       ('agathaling@gmail.com', 'Agatha Maria Ling', '2cd6ee2c70b0bde53fbe6cac3c8b8bb1', '21983758316',
        '543.333.333-44', '1992-01-15', 'F'),
       ('gabyfig@gmail.com', 'Gabriela Machado Figueiredo', 'e29311f6f1bf1af907f9ef9f44b8328b', '92993833391',
        '324.444.988-87', '2003-05-19', 'F'),
       ('marcosvin@gmail.com', 'Marcos Vinicius Freire', '9ffbf43126e33be52cd2bf7e01d627f9', '15933132213',
        '002.555.877-21', '1993-06-21', 'M'),
       ('paulo_jose@gmail.com', 'Jose Paulo siqueira', '9a8ad92c50cae39aa2c5604fd0ab6d8c', '38991123376',
        '321.952.321-23', '2002-02-18', 'M'),
       ('amanda.silva@gmail.com', 'Amanda Silva souza', 'f5302386464f953ed581edac03556e55', '14392911573',
        '123.877.776-11', '1993-02-19', 'F'),
       ('alexandremelo@gmail.com', 'Alexandre Queiroz Melo', '01fbdc44ef819db6273bc30965a23814', '21983711316',
        '543.456.333-54', '1992-07-15', 'F'),
       ('correamargarida@gmail.com', 'Margarida Correa', '372e25f23b5a8ae33c7ba203412ace30', '92993834491',
        '324.876.988-44', '2003-01-19', 'F'),
       ('wellxavier@gmail.com', 'Wellington Xavier', 'ddd5752b5fe66fd98fb9dcdee48b4473', '15993442243',
        '004.987.877-76', '1993-07-18', 'M');

insert into endereco (cod_postal, endereco, cliente_id)
values ('38400-457', 'Rua Fernando Costa, 15', 1),
       ('38411-555', 'Rua México, 124', 2),
       ('38411-104', 'Rua Blanche Galassi, 150', 3),
       ('17052-907', 'Rua Rafael Alves, 15', 4),
       ('11327-402', 'Av. Paulista, 114', 5),
       ('11327-402', 'Av. Paulista, 115', 6),
       ('32456-457', 'Rua Patrulheiro Osmar tavares, 15', 7),
       ('38766-576', 'Rua Salvador, 124', 8),
       ('63042-104', 'Rua Natal, 150', 9),
       ('12889-907', 'Rua Buriti Alegre, 15', 10),
       ('98711-402', 'Av. Ivaldo Alves Nascimento, 114', 11),
       ('38412-486', 'Av. Mauá, 115', 12),
       ('38322-466', 'Rua Jataí, 15', 13),
       ('38655-234', 'Rua Joao tobias, 124', 14),
       ('38452-145', 'Av. Peru, 150', 15);

insert into cartao (numero, nome, expiracao, cliente_id)
values ('1111111111111111', 'LUIZ F. B.', '2027-06-13', 1),
       ('1234567891011121', 'ANTONIO C.', '2028-02-19', 2),
       ('2222222222222222', 'LUCAS S.', '2025-10-03', 3),
       ('4444444444444444', 'LAURA R.', '2030-03-21', 4),
       ('5555555555555555', 'MARCOS S.', '2024-05-05', 5),
       ('8999999999999999', 'MICHAEL S.', '2022-07-15', 6),
       ('1122221111111111', 'CAROLINA S.', '2027-06-13', 7),
       ('1234888891011121', 'AGATHA L.', '2028-02-19', 8),
       ('2222278232222222', 'GABRIELA F.', '2025-10-03', 9),
       ('4897644444444444', 'MARCOS V. F.', '2030-03-21', 10),
       ('5555555895655555', 'JOSE PAULO', '2024-05-05', 11),
       ('3339873533333333', 'AMANDA S.', '2022-07-15', 12),
       ('1111112345911111', 'ALEXANDRE Q.', '2027-06-13', 13),
       ('1234567854363121', 'MARGARIDA C.', '2028-02-19', 14),
       ('2222567432222222', 'WELLINGTON X.', '2025-10-03', 15),
       ('1187463789092637', 'FABRICIO SOARES', '2024-05-19', 6),
       ('1218909678954321', 'JULIANA DONER.', '2028-08-14', 14);

insert into pedido (data_pedido, status_pedido, data_entrega, preco_total, frete_total, cliente_id, endereco_id,
                    cartao_id, n_parcelas)
values ('2022-05-13', 'Aguardando pagamento', null, 10000, 62, 1, 1, 1, 1),
       ('2022-03-10', 'Processando', null, 4100, 40, 2, 2, 2, 1),
       ('2022-02-01', 'Em transporte', null, 4200, 45, 3, 3, 3, 2),
       ('2022-07-12', 'Em transporte', null, 7100, 69, 4, 4, 4, 1),
       ('2022-07-04', 'Entregue', '2022-07-11', 3200, 50, 5, 5, 5, 2),
       ('2022-05-13', 'Entregue', '2022-01-01', 3300, 31, 6, 6, 6, 1),
       ('2022-03-10', 'Processando', null, 5000, 29, 7, 7, 7, 1),
       ('2022-02-01', 'Em transporte', null, 9000, 36, 8, 8, 8, 2),
       ('2022-07-12', 'Em transporte', null, 2300, 7, 9, 9, 9, 1),
       ('2022-07-12', 'Em transporte', null, 8000, 70, 14, 14, 14, 1),
       ('2022-07-04', 'Entregue', '2022-07-11', 7000, 27, 15, 15, 15, 2),
       ('2022-05-13', 'Entregue', '2022-01-01', 500, 0, 1, 1, 1, 1),
       ('2022-03-10', 'Processando', null, 2300, 20, 3, 3, 3, 1),
       ('2023-02-13', 'Em transporte', null, 2000, 10, 2, 1, 2, 3),
       ('2023-02-10', 'Entregue', '2023-02-13', 2000, 12, 2, 2, 2, 4),
       ('2023-03-10', 'Entregue', '2023-03-13', 3000, 0, 1, 3, 1, 4),
       ('2023-03-15', 'Em transporte', null, 150, 0, 3, 3, 3, 1),
       ('2023-03-25', 'Em transporte', null, 400, 0, 3, 3, 3, 1),
       ('2023-02-25', 'Em transporte', null, 2000.00, 50, 3, 3, 3, 1),
       ('2023-02-25', 'Em transporte', null, 2000.00, 20, 1, 1, 1, 1);

insert into pedido_produto(pedido_id, produto_id, preco, quantidade, frete)
VALUES (1, 1, 6000.00, 1, 10),
       (2, 2, 100.00, 3, 12),
       (3, 3, 2000.00, 1, 0),
       (4, 5, 400.00, 2, 7),
       (5, 6, 200.00, 1, 30),
       (6, 7, 300.00, 1, 16),
       (7, 8, 1000.00, 3, 13),
       (8, 9, 3000.00, 1, 13),
       (9, 10, 2000.00, 1, 7),
       (10, 1, 6000.00, 1, 20),
       (11, 1, 6000.00, 1, 12),
       (12, 2, 100.00, 3, 0),
       (13, 3, 2000.00, 1, 0),
       (1, 4, 1000.00, 1, 12),
       (2, 5, 400.00, 2, 3),
       (3, 6, 200.00, 1, 20),
       (4, 7, 300.00, 1, 12),
       (5, 8, 1000.00, 3, 20),
       (6, 9, 3000.00, 1, 15),
       (7, 10, 2000.00, 1, 16),
       (8, 1, 6000.00, 1, 23),
       (9, 2, 100.00, 3, 0),
       (10, 3, 2000.00, 1, 50),
       (11, 4, 1000.00, 1, 15),
       (12, 6, 200.00, 1, 0),
       (13, 7, 300.00, 1, 20),
       (1, 8, 1000.00, 3, 40),
       (2, 9, 3000.00, 1, 25),
       (3, 10, 2000.00, 1, 25),
       (4, 1, 6000.00, 1, 50),
       (14, 3, 2000.00, 1, 10),
       (15, 3, 2000.00, 1, 12),
       (16, 9, 3000.00, 1, 0),
       (17, 11, 150.00, 1, 0),
       (18, 5, 400.00, 1, 20),
       (19, 3, 2000.00, 1, 50),
       (20, 3, 2000.00, 1, 20);

insert into carrinho(cliente_id, produto_id, quantidade)
VALUES (5, 1, 1),
       (5, 3, 3),
       (4, 3, 1),
       (3, 4, 1),
       (2, 5, 2),
       (1, 1, 1),
       (7, 2, 1),
       (7, 8, 3),
       (8, 9, 1),
       (9, 10, 1),
       (11, 2, 1),
       (15, 1, 1),
       (12, 3, 3),
       (1, 3, 1),
       (7, 4, 1),
       (10, 5, 2),
       (9, 1, 1),
       (10, 2, 1),
       (1, 8, 3),
       (3, 9, 1),
       (2, 10, 1),
       (6, 2, 1),
       (2, 3, 2),
       (1, 9, 1),
       (3, 11, 1),
       (3, 5, 1);

insert into comentario(cliente_id, produto_id, comentario, avaliacao, data_comentario)
VALUES (1, 1, 'Produto de qualidade', 5, '2022-05-13'),
       (9, 2, 'Top', 5, '2022-03-10'),
       (3, 3, 'Bom', 4, '2022-02-01'),
       (4, 4, 'Deixa a desejar', 1, '2022-07-12'),
       (6, 5, 'Produto de qualidade', 4, '2022-07-04'),
       (8, 7, 'Produto de qualidade', 5, '2022-05-13'),
       (2, 8, 'Top', 5, '2022-03-10'),
       (11, 6, 'Bom', 4, '2022-02-01'),
       (13, 9, 'Deixa a desejar', 2, '2022-07-12'),
       (10, 10, 'Produto de qualidade', 4, '2022-07-04');


-- =========================================== EXERCÍCIO 1 - JOÃO MARCOS ===========================================

-- A) Inserir categoria
DELIMITER $
CREATE PROCEDURE insere_categoria(var_id_categoria int, var_descricao varchar(50))
BEGIN
    case
        when (var_descricao is null) then select 'Adicione descrição' as Erro;
        else insert into categoria (id_categoria, descricao) VALUES (var_id_categoria, var_descricao);
    end case;
END $
DELIMITER ;

call insere_categoria(null, 'Pet');
call insere_categoria(null, 'Informática');
call insere_categoria(null, 'Telefonia');
call insere_categoria(null, null);


-- b) Listar quantidade de itens no carrinho que ainda nao foram comprados informando a região através de código
-- de área DDD ex (34,11)
DELIMITER $
CREATE PROCEDURE listar_Carrinho(ddd varchar(2))
BEGIN
    case
        when (ddd is null) then select 'Insira o DDD' as Erro;
        when (ddd not in (SELECT LEFT(c.telefone, 2)
                          from cliente c
                                   inner join carrinho cr on c.id_cliente = cr.cliente_id
                          where LEFT(c.telefone, 2) = ddd)) then select 'Nenhum registro nessa região' as Erro;
        else select c.nome, c.telefone, c.email, sum(cr.quantidade) as qtdItensCarrinho
             from cliente c
                      inner join carrinho cr on c.id_cliente = cr.cliente_id
             where (SELECT LEFT(c.telefone, 2)) = ddd
             group by c.nome
             order by qtdItensCarrinho desc;
    end case;
END $
DELIMITER ;

call listar_Carrinho(11);
call listar_Carrinho(34);
call listar_Carrinho(00);
call listar_Carrinho(null);


-- c) Procedure para listar cliente com cartão vencendo a partir de uma data informada, sendo listada datas mais
-- proximas do vencimento da data informada, será listado nome, email e quantidade de produtos no carrinho e quantidade
-- de dias que faltam para o cartão expirar a partir de hoje.
DELIMITER $
CREATE PROCEDURE produtos_carrinho(dtCartao date)
BEGIN
    select c.nome,
           c.email,
           sum(cr.quantidade)                      as somaItensCarrinho,
           ct.expiracao,
           timestampdiff(day, now(), ct.expiracao) as DiasExpiracao
    from cliente c
             inner join carrinho cr on c.id_cliente = cr.cliente_id
             inner join cartao ct on c.id_cliente = ct.cliente_id
    where ct.expiracao >= dtCartao
    group by c.nome
    order by ct.expiracao;
END $
DELIMITER ;

call produtos_carrinho('2030-02-13');
call produtos_carrinho('2025-02-13');
call produtos_carrinho('2023-02-13');


-- =========================================== EXERCÍCIO 1 - JOÃO PEDRO ===========================================

-- A) Insere Tabela cliente
DELIMITER $$
CREATE PROCEDURE insere_cliente(var_email varchar(50), var_nome varchar(50), var_senha varchar(50),
                                var_telefone varchar(15), var_cpf varchar(15), var_dt_nascimento date, var_sexo char(1))
BEGIN
    if (var_email is null) then
        select 'Email é obrigatorio' as msg;
    elseif (var_nome is null) then
        select 'Nome é obrigatorio' as msg;
    elseif (var_senha is null) then
        select 'Senha é obrigatorio' as msg;
    elseif (var_telefone is null) then
        select 'Telefone é obrigatorio' as msg;
    elseif (var_cpf is null) then
        select 'CPF é obrigatorio' as msg;
    elseif (var_dt_nascimento is null) then
        select 'Data de nascimento é obrigatorio' as msg;
    elseif (var_sexo is null) then
        select 'Sexo é obrigatorio' as msg;
    else
        insert into cliente(email, nome, senha, telefone, cpf, dt_nascimento, sexo)
        values (var_email, var_nome, var_senha, var_telefone, var_cpf, var_dt_nascimento, var_sexo);
    end if;
END $$
DELIMITER ;

call insere_cliente(null, 'Marcos Paulo', 'senha123', '34992749333', '333.222.444-11', '2000-01-10', 'M');
call insere_cliente('marcospaulo@mail.com', null, 'senha123', '34992749333', '333.222.444-11', '2000-01-10', 'M');
call insere_cliente('marcospaulo@mail.com', 'Marcos Paulo', null, '34992749333', '333.222.444-11', '2000-01-10', 'M');
call insere_cliente('marcospaulo@mail.com', 'Marcos Paulo', 'senha123', null, '333.222.444-11', '2000-01-10', 'M');
call insere_cliente('marcospaulo@mail.com', 'Marcos Paulo', 'senha123', '34992749333', null, '2000-01-10', 'M');
call insere_cliente('marcospaulo@mail.com', 'Marcos Paulo', 'senha123', '34992749333', '333.222.444-11', null, 'M');
call insere_cliente('marcospaulo@mail.com', 'Marcos Paulo', 'senha123', '34992749333', '333.222.444-11', '2000-01-10',
                    null);
call insere_cliente('marcospaulo@mail.com', 'Marcos Paulo', 'senha123', '34992749333', '333.222.444-11', '2000-01-10',
                    'M');


-- B) Procedure que busca os top 3 clientes que gastaram mais em um determinado periodo.
DELIMITER $$
CREATE PROCEDURE busca_cliente_que_gastaram_mais_em_um_periodo(data_inicial date, data_final date)
BEGIN
    if (data_final <= data_inicial) then
        SELECT 'Data inicial nao pode ser menor que a data final' AS MSG;
    else
        select c.nome, c.email, sum(p.preco_total) as valor_gasto_total
        from cliente c
                 inner join pedido p on p.cliente_id = c.id_cliente
        where p.data_pedido BETWEEN data_inicial and data_final
        group by cliente_id
        order by 3 desc
        limit 3;
    end if;
END $$
DELIMITER ;

call busca_cliente_que_gastaram_mais_em_um_periodo('2023-04-01', '2023-03-01');
call busca_cliente_que_gastaram_mais_em_um_periodo('2023-03-01', '2023-04-01');


-- C) Procedure que lista todos os dados do cliente (sem a senha), o endereço formato (logadouro+cep) desde que possuam
-- uma idade >= a informada.
DELIMITER $$
CREATE PROCEDURE lista_cliente_endereco(idade int)
BEGIN
    if (idade <= 0) then
        SELECT 'Idade nao pode ser menor ou igual a 0' as msg;
    else
        select id_cliente,
               email,
               nome,
               telefone,
               cpf,
               dt_nascimento,
               sexo,
               concat(e.endereco, '. CEP: ', e.cod_postal) as endereco
        from cliente c
                 inner join endereco e on e.cliente_id = c.id_cliente
        where (year(CURRENT_DATE()) - year(c.dt_nascimento)) >= idade;
    end if;
END $$
DELIMITER ;

call lista_cliente_endereco(0);
call lista_cliente_endereco(25);


-- =========================================== EXERCÍCIO 1 - JOÃO VITOR ===========================================

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


-- =========================================== EXERCÍCIO 1 - LAURA ===========================================

-- A) Insere produtos na tabela, apenas se estiverem com dados obrigatórios
DELIMITER $$
CREATE PROCEDURE insere_produto(var_nome varchar(50), var_descricao text, var_preco numeric(9, 2), var_estoque int,
                                var_categoria_id int, var_loja_id int)
BEGIN
    if (var_nome is null) then
        select 'Nome do PRODUTO é obrigatorio' as msg;
    elseif (var_descricao is null) then
        select 'Descrição do PRODUTO é obrigatorio' as msg;
    elseif (var_preco is null) then
        select 'PRECO do PRODUTO é obrigatorio' as msg;
    elseif (var_estoque is null) then
        select 'ESTOQUE do PRODUTO é obrigatorio' as msg;
    elseif (var_categoria_id is null) then
        select 'CATEGORIA do PRODUTO é obrigatorio' as msg;
    elseif (var_loja_id is null) then
        select 'ID DA LOJA do PRODUTO é obrigatorio' as msg;
    else
        insert into produto(nome, descricao, preco, estoque, categoria_id, loja_id)
        values (var_nome, var_descricao, var_preco, var_estoque, var_categoria_id, var_loja_id);
    end if;
END $$
DELIMITER ;

call insere_produto(null, 'iPHONE 14 PRO MAX ', 7991.87, 9, 2, 3);
call insere_produto('CAMISA', null, 32.90, 12, 1, 5);
call insere_produto('BOLSA DE ACADEMIA', ' NIKE - tamanho GG ', null, 9, 2, 2);
call insere_produto('MOUSE', 'Dispositivo apontador para computador.', 200.00, null, 3, 5);
call insere_produto('CAMISA POLO', 'Roupa modelo esporte fino.', 150.00, 300, null, 2);
call insere_produto('AIRPODS', 'Fones de ouvido sem fio da Apple.', 1300.00, 400, 3, null);
call insere_produto('AIRPODS 2', 'Fones de ouvido sem fio da Apple.', 1300.00, 400, 3, 2);


-- B) Procedure que busca os top 3 produtos vendidos em um determinado período
DELIMITER $$
CREATE PROCEDURE Top3produtos(IN start_date DATE, IN end_date DATE)
BEGIN
    SELECT p.id_produto, p.nome, SUM(pp.quantidade) AS total_vendas
    FROM produto p
             JOIN pedido_produto pp ON p.id_produto = pp.produto_id
             JOIN pedido ped ON pp.pedido_id = ped.id_pedido
    WHERE ped.data_pedido BETWEEN start_date AND end_date
    GROUP BY p.id_produto, p.nome
    ORDER BY total_vendas DESC
    LIMIT 3;
END $$
DELIMITER ;

CALL Top3produtos('2022-01-01', '2023-03-13');


-- C) Procedure que lista todos os clientes com pedidos com status "PROCESSANDO"
DELIMITER $$
CREATE PROCEDURE ProdutosEmProcessamento()
BEGIN
    SELECT c.nome AS nome_cliente, p.nome AS nome_produto, ped.status_pedido AS status_pedido
    FROM cliente c
             JOIN pedido ped ON c.id_cliente = ped.cliente_id
             JOIN pedido_produto pp ON ped.id_pedido = pp.pedido_id
             JOIN produto p ON pp.produto_id = p.id_produto
    WHERE ped.status_pedido = 'PROCESSANDO';
END $$
DELIMITER ;

call ProdutosEmProcessamento();


-- =========================================== EXERCÍCIO 2 - GRUPO ===========================================

-- A) Funcao que calcula o valor total de produtos em estoque para controle financeiro.
delimiter $
create function calc_vlr_total_produtos_em_estoque(var_produto_id int) returns numeric(9, 2)
begin
    return (select sum(preco * estoque) from produto where id_produto = var_produto_id);
end $
delimiter ;

select calc_vlr_total_produtos_em_estoque(1);


-- =========================================== EXERCÍCIO 2 - JOÃO MARCOS ===========================================

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


-- =========================================== EXERCÍCIO 2 - JOÃO PEDRO ===========================================

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


-- =========================================== EXERCÍCIO 2 - JOÃO VITOR ===========================================

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


-- =========================================== EXERCÍCIO 2 - LAURA ===========================================

-- A) Funçao para alteraçao de senha validando nome, cpf e data de nascimento
SET GLOBAL log_bin_trust_function_creators = 1;

drop function if exists alterarSenha;
DELIMITER |
CREATE FUNCTION alterarSenha(var_id_cliente INT(11), nome VARCHAR(50), cpf VARCHAR(15), dt_nascimento DATE,
                             nova_senha VARCHAR(50)) RETURNS VARCHAR(50)
BEGIN
    DECLARE novaSenha VARCHAR(50);
    IF (nome != (SELECT cliente.nome FROM cliente WHERE cliente.id_cliente = var_id_cliente)) THEN
        RETURN 'Dados não conferem';
    END IF;
    IF (cpf != (SELECT cliente.cpf FROM cliente WHERE cliente.id_cliente = var_id_cliente)) THEN
        RETURN 'Dados não conferem';
    END IF;
    IF (dt_nascimento != (SELECT cliente.dt_nascimento FROM cliente WHERE cliente.id_cliente = var_id_cliente)) THEN
        RETURN 'Dados não conferem';
    END IF;
    SET novaSenha = md5(nova_senha);
    UPDATE cliente SET senha = novaSenha WHERE cliente.id_cliente = var_id_cliente;
    RETURN novaSenha;
END |
DELIMITER ;

select alterarSenha(1, 'X', '222.222.222-22', '2001-04-23', 'KKK');
select alterarSenha(2, 'Antônio Cardoso Medeiros', '123.456.789-11', '1998-02-11', 'JHASA');
select alterarSenha(3, 'Vanderlei', '1222', '1998-02-11', 'ALOU');
select alterarSenha(4, 'Laura Ribeiro Mathias', '444.444.444-44', '1976-07-13', '43321223');


-- =========================================== EXERCÍCIO 3 - GRUPO ===========================================

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


-- =========================================== EXERCÍCIO 3 - JOÃO MARCOS ===========================================

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


-- =========================================== EXERCÍCIO 3 - JOÃO PEDRO ===========================================

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


-- =========================================== EXERCÍCIO 3 - JOÃO VITOR ===========================================

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


-- =========================================== EXERCÍCIO 3 - LAURA ===========================================

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
