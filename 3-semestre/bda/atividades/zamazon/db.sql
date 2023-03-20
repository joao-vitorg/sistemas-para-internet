drop database if exists zamazon;
create database zamazon;
use zamazon;

create table fornecedor
(
    id       int auto_increment primary key,
    cnpj     varchar(18) unique,
    nome     varchar(50),
    telefone varchar(15)
);

create table categoria
(
    id        int primary key auto_increment,
    descricao varchar(50)
);

create table produto
(
    id           int primary key auto_increment,
    nome         varchar(50),
    preco        numeric(9, 2),
    descricao    text,
    estoque      int,
    categoriaId  int,
    fornecedorId int,
    foreign key (categoriaId) references categoria (id),
    foreign key (fornecedorId) references fornecedor (id)
);

create table cliente
(
    id            int primary key auto_increment,
    email         varchar(50) unique,
    nome          varchar(50),
    senha         varchar(50),
    telefone      varchar(15),
    cpf           varchar(15) unique,
    dt_nascimento date,
    sexo          char
);

create table endereco
(
    id        int primary key auto_increment,
    codPostal varchar(9),
    endereco  varchar(50),
    clienteId int,
    foreign key (clienteId) references cliente (id)
);

create table cartao
(
    id        int primary key auto_increment,
    numero    varchar(16),
    nome      varchar(50),
    expiracao date,
    clienteId int,
    foreign key (clienteId) references cliente (id)
);

create table pedido
(
    id           int primary key auto_increment,
    frete        numeric(9, 2),
    dataPedido   date,
    statusPedido varchar(100),
    dataEntrega  date,
    clienteId    int,
    enderecoId   int,
    cartaoId     int,
    nParcelas    int,
    foreign key (clienteId) references cliente (id),
    foreign key (enderecoId) references endereco (id),
    foreign key (cartaoId) references cartao (id)
);

create table pedidoProduto
(
    pedidoId   int,
    produtoId  int,
    preco      numeric(9, 2),
    quantidade int,
    primary key (pedidoId, produtoId),
    foreign key (pedidoId) references pedido (id),
    foreign key (produtoId) references produto (id)
);

create table carrinho
(
    clienteId  int,
    produtoId  int,
    quantidade int,
    primary key (clienteId, produtoId),
    foreign key (clienteId) REFERENCES cliente (id),
    foreign key (produtoId) REFERENCES produto (id)
);

create table comentario
(
    clienteId      int,
    produtoId      int,
    comentario     varchar(250),
    avaliacao      int,
    dataComentario date,
    primary key (clienteId, produtoId),
    foreign key (clienteId) REFERENCES cliente (id),
    foreign key (produtoId) REFERENCES produto (id)
);

use zamazon;

insert into fornecedor(cnpj, nome, telefone)
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

insert into produto (nome, preco, estoque, categoriaId, fornecedorId)
values ('Iphone 14', 6500.00, 500, 1, 1),
       ('Camiseta', 100.00, 300, 2, 2),
       ('Galaxy S20', 2000.00, 600, 1, 3),
       ('AirPods', 1300.00, 400, 3, 1),
       ('Headset', 400.00, 300, 4, 4),
       ('Mouse', 200.00, 200, 3, 5),
       ('Teclado', 300.00, 100, 3, 5),
       ('Monitor', 1000.00, 500, 5, 3),
       ('Notebook', 3000.00, 300, 3, 3),
       ('Smart TV', 2000.00, 200, 5, 3);

insert into cliente (email, nome, senha, telefone, cpf, dt_nascimento, sexo)
values ('luiz@gmail.com', 'Luiz Fernando Barbosa', '0cc175b9c0f1b6a831c399e269772661', '34992749276', '222.222.222-22',
        '2001-04-23', 'M'),
       ('antonio@gmail.com', 'Antônio Cardoso Medeiros', '92eb5ffee6ae2fec3ad71c777531578f', '11392759573', '123.456.789-11',
        '1998-02-11', 'M'),
       ('Lucas@gmail.com', 'Lucas Souza Santos', '4a8a08f09d37b73795649038408b5f33', '11993758316', '333.333.333-33',
        '1998-05-15', 'M'),
       ('laura@gmail.com', 'Laura Ribeiro Mathias', '8277e0910d750195b448797616e091ad', '51993857391', '444.444.444-44',
        '1976-07-13', 'F'),
       ('marcos@gmail.com', 'Marcos Silva Vieira', '1679091c5a880faf6fb5e6087eb1b2dc', '11993937313', '555.555.555-55',
        '1965-09-10', 'M'),
        ('scottmichael@gmail.com', 'Michael Scott', '---', '38992723376', '321.222.321-22',
        '2002-03-11', 'M'),
       ('carolfs@gmail.com', 'Carolina Ferreira Souza', '----', '14392982573', '123.877.789-66',
        '1993-01-12', 'F'),
       ('agathaling@gmail.com', 'Agatha Maria Ling', '----', '21983758316', '543.333.333-44',
        '1992-01-15', 'F'),
       ('gabyfig@gmail.com', 'Gabriela Machado Figueiredo', '----', '92993833391', '324.444.988-87',
        '2003-05-19', 'F'),
       ('marcosvin@gmail.com', 'Marcos Vinicius Freire', '----', '15933132213', '002.555.877-21',
        '1993-06-21', 'M'),
        ('paulo_jose@gmail.com', 'Jose Paulo siqueira', '---', '38991123376', '321.952.321-23',
        '2002-02-18', 'M'),
       ('amanda.silva@gmail.com', 'Amanda Silva souza', '----', '14392911573', '123.877.776-11',
        '1993-02-19', 'F'),
       ('alexandremelo@gmail.com', 'Alexandre Queiroz Melo', '----', '21983711316', '543.456.333-54',
        '1992-07-15', 'F'),
       ('correamargarida@gmail.com', 'Margarida Correa', '----', '92993834491', '324.876.988-44',
        '2003-01-19', 'F'),
       ('wellxavier@gmail.com', 'Wellington Xavier', '----', '15993442243', '004.987.877-76',
        '1993-07-18', 'M');
        

insert into endereco (codPostal, endereco, clienteId)
values ('38400-457', 'Rua Fernando Costa, 15', 1),
       ('38411-555', 'Rua México, 124', 2),
       ('38411-104', 'Rua Blanche Galassi, 150', 3),
       ('17052-907', 'Rua Rafael Alves, 15', 4),
       ('01327-402', 'Av. Paulista, 114', 5),
       ('01327-402', 'Av. Paulista, 115', 6),  
       ('32456-457', 'Rua Patrulheiro Osmar tavares, 15', 7),
       ('38766-576', 'Rua Salvador, 124', 8),
       ('69042-104', 'Rua Natal, 150', 9),
       ('12889-907', 'Rua Buriti Alegre, 15', 10),
       ('98711-402', 'Av. Ivaldo Alves Nascimento, 114', 11),
       ('38412-486', 'Av. Mauá, 115', 12),
       ('38322-466', 'Rua Jataí, 15', 13),
       ('38655-234', 'Rua Joao tobias, 124', 14),
       ('38452-145', 'Av. Peru, 150', 15);

insert into cartao (numero, nome, expiracao, clienteId)
values ('1111111111111111', 'LUIZ F. B.', '2027-06-13', 1),
       ('1234567891011121', 'ANTONIO C.', '2028-02-19', 2),
       ('2222222222222222', 'LUCAS S.', '2025-10-03', 3),
       ('4444444444444444', 'LAURA R.', '2030-03-21', 4),
       ('5555555555555555', 'MARCOS S.', '2024-05-05', 5),
       ('8999999999999999', 'MICHAEL S.', '2022-07-15', 6,
       ('1122221111111111', 'CAROLINA S.', '2027-06-13', 7),
       ('1234888891011121', 'AGATHA L.', '2028-02-19', 8),
       ('2222278232222222', 'GABRIELA F.', '2025-10-03', 9),
       ('4897644444444444', 'MARCOS V. F.', '2030-03-21', 10),
       ('5555555895655555', 'JOSE PAULO', '2024-05-05', 11),
       ('3339873533333333', 'AMANDA S.', '2022-07-15', 12)
       ('1111112345911111', 'ALEXANDRE Q.', '2027-06-13', 13),
       ('1234567854363121', 'MARGARIDA C.', '2028-02-19', 14),
       ('2222567432222222', 'WELLINGTON X.', '2025-10-03', 15);

insert into pedido (frete, dataPedido, statusPedido, dataEntrega, clienteId, enderecoId, cartaoId, nParcelas)
values (15.00, '2022-05-13', 'Aguardando pagamento', null, 1, 1, 1, 1),
       (13.00, '2022-03-10', 'Processando', null, 2, 2, 2, 1),
       (20.00, '2022-02-01', 'Em transporte', null, 3, 3, 3, 2),
       (15.00, '2022-07-12', 'Em transporte', null, 4, 4, 4, 1),
       (30.00, '2022-07-04', 'Entregue', '2022-07-11', 5, 5, 5, 2),
       (15.00, '2022-05-13', 'Entregue', '2022-01-01', 6, 6, 6, 1),
       (13.00, '2022-03-10', 'Processando', null, 7, 7, 7, 1),
       (20.00, '2022-02-01', 'Em transporte', null, 8, 8, 8, 2),
       (15.00, '2022-07-12', 'Em transporte', null, 9, 9, 9, 1),
       (30.00, '2022-07-04', 'Entregue', '2022-07-11', 10, 10, 10, 2),
       (15.00, '2022-05-13', 'Aguardando pagamento', null, 11, 11, 11, 1),
       (13.00, '2022-03-10', 'Processando', null, 12, 12, 12, 1),
       (20.00, '2022-02-01', 'Em transporte', null, 13, 13, 13, 2),
       (15.00, '2022-07-12', 'Em transporte', null, 14, 14, 14, 1),
       (30.00, '2022-07-04', 'Entregue', '2022-07-11', 15, 15, 15, 2),
       (15.00, '2022-05-13', 'Entregue', '2022-01-01', 1, 1, 1, 1),
       (13.00, '2022-03-10', 'Processando', null, 3, 3, 3, 1),
       (20.00, '2022-02-01', 'Em transporte', null, 5, 5, 5, 2),
       (15.00, '2022-07-12', 'Em transporte', null, 6, 6, 6, 1),
       (30.00, '2022-07-04', 'Entregue', '2022-07-11', 7, 7, 7, 2),
       (15.00, '2022-05-13', 'Aguardando pagamento', null, 1, 1, 1, 1),
       (13.00, '2022-03-10', 'Processando', null, 2, 2, 2, 1),
       (20.00, '2022-02-01', 'Em transporte', null, 3, 3, 3, 2),
       (15.00, '2022-07-12', 'Em transporte', null, 9, 9,9, 1),
       (30.00, '2022-07-04', 'Entregue', '2022-07-11', 5, 5, 5, 2),
       (15.00, '2022-05-13', 'Entregue', '2022-01-01', 3, 3, 3, 1),
       (13.00, '2022-03-10', 'Processando', null, 2, 2, 2, 1),
       (20.00, '2022-02-01', 'Em transporte', null, 4, 4, 4, 2),
       (15.00, '2022-07-12', 'Em transporte', null, 5, 5, 5, 1),
       (30.00, '2022-07-04', 'Entregue', '2022-07-11', 2,2, 2, 2);

insert into pedidoProduto(pedidoId, produtoId, preco, quantidade)
VALUES (1, 1, 6500.00, 1),
       (2, 2, 100.00, 3),
       (3, 3, 2000.00, 1),
       (4, 5, 400.00, 2),
       (5, 6, 200.00, 1),
       (6, 7, 300.00, 1),
       (7, 8, 1000.00, 3),
       (8, 9, 3000.00, 1),
       (9, 10, 2000.00, 1),
       (10, 1, 6500.00, 1),
       (11, 1, 6500.00, 1),
       (12, 2, 100.00, 3),
       (13, 3, 2000.00, 1),
       (14, 4, 1300.00, 1),
       (15, 5, 400.00, 2),
       (16, 6, 200.00, 1),
       (17, 7, 300.00, 1),
       (18, 8, 1000.00, 3),
       (19, 9, 3000.00, 1),
       (20, 10, 2000.00, 1),
       (21, 1, 6500.00, 1),
       (22, 2, 100.00, 3),
       (23, 3, 2000.00, 1),
       (24, 4, 1300.00, 1),
       (25, 6, 200.00, 1),
       (26, 7, 300.00, 1),
       (27, 8, 1000.00, 3),
       (28, 9, 3000.00, 1),
       (29, 10, 2000.00, 1),
       (30, 1, 6500.00, 1);
       

insert into carrinho(clienteId, produtoId, quantidade)
VALUES (5, 1, 1),
       (5, 3, 3),
       (4, 3, 1),
       (3, 4, 1),
       (2, 5, 2),
       (1, 1, 1),
       (6, 2, 1),
       (7, 8, 3),
       (8, 9, 1),
       (9, 10, 1),
       (11, 2, 1),
       (15, 1, 1),
       (12, 3, 3),
       (1, 3, 1),
       (7, 4, 1),
       (17, 5, 2),
       (9, 1, 1),
       (10, 2, 1),
       (1, 8, 3),
       (3, 9, 1),
       (2, 10, 1),
       (6, 2, 1);

insert into comentario(clienteId, produtoId, comentario, avaliacao, dataComentario)
VALUES (1, 1, 'Produto de qualidade', 5, '2022-05-13'),
       (9, 2, 'Top', 5, '2022-03-10'),
       (3, 3, 'Bom', 4, '2022-02-01'),
       (4, 4, 'Deixa a desejar', 3, '2022-07-12'),
       (6, 5, 'Produto de qualidade', 4, '2022-07-04'),
       (8, 7, 'Produto de qualidade', 5, '2022-05-13'),
       (2, 8, 'Top', 5, '2022-03-10'),
       (11, 6, 'Bom', 4, '2022-02-01'),
       (13, 9, 'Deixa a desejar', 3, '2022-07-12'),
       (10, 10, 'Produto de qualidade', 4, '2022-07-04');;
