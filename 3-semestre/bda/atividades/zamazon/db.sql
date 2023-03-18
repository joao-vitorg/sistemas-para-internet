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
        '2022-05-13', 'M'),
       ('antonio@gmail.com', 'Antônio Cardoso', '92eb5ffee6ae2fec3ad71c777531578f', '11392759573', '123.456.789-11',
        '2022-05-13', 'M'),
       ('Lucas@gmail.com', 'Lucas Souza', '4a8a08f09d37b73795649038408b5f33', '11993758316', '333.333.333-33',
        '2022-05-13', 'M'),
       ('laura@gmail.com', 'Laura Ribeiro', '8277e0910d750195b448797616e091ad', '51993857391', '444.444.444-44',
        '2022-05-13', 'F'),
       ('marcos@gmail.com', 'Marcos Silva', '1679091c5a880faf6fb5e6087eb1b2dc', '11993937313', '555.555.555-55',
        '2022-05-13', 'M');

insert into endereco (codPostal, endereco, clienteId)
values ('38400-457', 'Rua Fernando Costa, 15', 1),
       ('38411-555', 'Rua México, 124', 2),
       ('38411-104', 'Rua Blanche Galassi, 150', 3),
       ('17052-907', 'Rua Rafael Alves, 15', 4),
       ('01327-402', 'Av. Paulista, 114', 5),
       ('01327-402', 'Av. Paulista, 115', 3);

insert into cartao (numero, nome, expiracao, clienteId)
values ('1111111111111111', 'LUIZ F. B.', '2027-06-13', 1),
       ('1234567891011121', 'ANTONIO C.', '2028-02-19', 2),
       ('2222222222222222', 'LUCAS S.', '2025-10-03', 3),
       ('4444444444444444', 'LAURA R.', '2030-03-21', 4),
       ('5555555555555555', 'MARCOS S.', '2024-05-05', 5),
       ('3333333333333333', 'LUCAS S.', '2022-07-15', 3);

insert into pedido (frete, dataPedido, statusPedido, dataEntrega, clienteId, enderecoId, cartaoId, nParcelas)
values (15.00, '2022-05-13', 'Aguardando pagamento', null, 1, 1, 1, 1),
       (13.00, '2022-03-10', 'Processando', null, 2, 2, 2, 1),
       (20.00, '2022-02-01', 'Em transporte', null, 3, 3, 3, 2),
       (15.00, '2022-07-12', 'Em transporte', null, 4, 4, 4, 1),
       (30.00, '2022-07-04', 'Entregue', '2022-07-11', 3, 6, 5, 2),
       (15.00, '2022-05-13', 'Entregue', '2022-01-01', 1, 1, 1, 1),
       (13.00, '2022-03-10', 'Processando', null, 2, 2, 2, 1),
       (20.00, '2022-02-01', 'Em transporte', null, 3, 6, 3, 2),
       (15.00, '2022-07-12', 'Em transporte', null, 5, 5, 4, 1),
       (30.00, '2022-07-04', 'Entregue', '2022-07-11', 5, 5, 5, 2);

insert into pedidoProduto(pedidoId, produtoId, preco, quantidade)
VALUES (1, 1, 6500.00, 1),
       (2, 2, 100.00, 3),
       (3, 3, 2000.00, 1),
       (3, 4, 1300.00, 1),
       (4, 5, 400.00, 2),
       (5, 6, 200.00, 1),
       (6, 7, 300.00, 1),
       (7, 8, 1000.00, 3),
       (8, 9, 3000.00, 1),
       (9, 10, 2000.00, 1),
       (10, 1, 6500.00, 1);

insert into carrinho(clienteId, produtoId, quantidade)
VALUES (5, 1, 1),
       (5, 3, 3),
       (4, 3, 1),
       (3, 4, 1),
       (2, 5, 2),
       (1, 1, 1),
       (5, 2, 1),
       (4, 8, 3),
       (3, 9, 1),
       (2, 10, 1),
       (1, 2, 1);

insert into comentario(clienteId, produtoId, comentario, avaliacao, dataComentario)
VALUES (1, 1, 'Produto de qualidade', 5, '2022-05-13'),
       (2, 2, 'Top', 5, '2022-03-10'),
       (3, 3, 'Bom', 4, '2022-02-01'),
       (4, 4, 'Deixa a desejar', 3, '2022-07-12'),
       (3, 5, 'Produto de qualidade', 4, '2022-07-04');
