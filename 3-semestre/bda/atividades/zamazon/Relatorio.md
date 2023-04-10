# Etapa 1: Modelo Físico, Carga de Dados e Relatórios

```sql
drop database if exists zamazon;
create database zamazon;
use zamazon;

create table loja
(
    id       int         not null auto_increment primary key,
    cnpj     varchar(18) not null unique,
    nome     varchar(50) not null,
    telefone varchar(15) not null
);


create table categoria
(
    id        int         not null primary key auto_increment,
    descricao varchar(50) not null
);

create table produto
(
    id           int           not null primary key auto_increment,
    nome         varchar(50)   not null,
    descricao    text          not null,
    preco        numeric(9, 2) not null,
    estoque      int           not null,
    categoria_id int           not null,
    loja_id      int           not null,
    foreign key (categoria_id) references categoria (id),
    foreign key (loja_id) references loja (id)
);

create table cliente
(
    id            int         not null primary key auto_increment,
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
    id         int         not null primary key auto_increment,
    cod_postal varchar(9)  not null,
    endereco   varchar(50) not null,
    cliente_id int         not null,
    foreign key (cliente_id) references cliente (id)
);

create table cartao
(
    id         int         not null primary key auto_increment,
    numero     varchar(16) not null,
    nome       varchar(50) not null,
    expiracao  date        not null,
    cliente_id int         not null,
    foreign key (cliente_id) references cliente (id)
);

create table pedido
(
    id            int           not null primary key auto_increment,
    data_pedido   date          not null,
    status_pedido varchar(100)  not null,
    data_entrega  date,
    n_parcelas    int           not null,
    preco_total   numeric(9, 2) not null,
    frete_total   numeric(9, 2) not null,
    cliente_id    int           not null,
    endereco_id   int           not null,
    cartao_id     int           not null,
    foreign key (cliente_id) references cliente (id),
    foreign key (endereco_id) references endereco (id),
    foreign key (cartao_id) references cartao (id)
);

create table pedido_produto
(
    pedido_id  int           not null,
    produto_id int           not null,
    preco      numeric(9, 2) not null,
    quantidade int           not null,
    frete      numeric(9, 2) not null,
    primary key (pedido_id, produto_id),
    foreign key (pedido_id) references pedido (id),
    foreign key (produto_id) references produto (id)
);

create table carrinho
(
    cliente_id int not null,
    produto_id int not null,
    quantidade int not null,
    primary key (cliente_id, produto_id),
    foreign key (cliente_id) REFERENCES cliente (id),
    foreign key (produto_id) REFERENCES produto (id)
);

create table comentario
(
    cliente_id      int          not null,
    produto_id      int          not null,
    comentario      varchar(250) not null,
    avaliacao       int          not null,
    data_comentario date         not null,
    primary key (cliente_id, produto_id),
    foreign key (cliente_id) REFERENCES cliente (id),
    foreign key (produto_id) REFERENCES produto (id)
);

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
values ('luiz@gmail.com', 'Luiz Fernando Barbosa', '0cc175b9c0f1b6a831c399e269772661', '34992749276', '222.222.222-22', '2001-04-23', 'M'),
       ('antonio@gmail.com', 'Antônio Cardoso Medeiros', '92eb5ffee6ae2fec3ad71c777531578f', '11392759573', '123.456.789-11', '1998-02-11', 'M'),
       ('Lucas@gmail.com', 'Lucas Souza Santos', '4a8a08f09d37b73795649038408b5f33', '11993758316', '333.333.333-33', '1998-05-15', 'M'),
       ('laura@gmail.com', 'Laura Ribeiro Mathias', '8277e0910d750195b448797616e091ad', '51993857391', '444.444.444-44', '1976-07-13', 'F'),
       ('marcos@gmail.com', 'Marcos Silva Vieira', '1679091c5a880faf6fb5e6087eb1b2dc', '11993937313', '555.555.555-55', '1965-09-10', 'M'),
       ('scottmichael@gmail.com', 'Michael Scott', '3b5d5c3712955042212316173ccf37be', '38992723376', '321.222.321-22', '2002-03-11', 'M'),
       ('carolfs@gmail.com', 'Carolina Ferreira Souza', '60b725f10c9c85c70d97880dfe8191b3', '14392982573', '123.877.789-66', '1993-01-12', 'F'),
       ('agathaling@gmail.com', 'Agatha Maria Ling', '2cd6ee2c70b0bde53fbe6cac3c8b8bb1', '21983758316', '543.333.333-44', '1992-01-15', 'F'),
       ('gabyfig@gmail.com', 'Gabriela Machado Figueiredo', 'e29311f6f1bf1af907f9ef9f44b8328b', '92993833391', '324.444.988-87', '2003-05-19', 'F'),
       ('marcosvin@gmail.com', 'Marcos Vinicius Freire', '9ffbf43126e33be52cd2bf7e01d627f9', '15933132213', '002.555.877-21', '1993-06-21', 'M'),
       ('paulo_jose@gmail.com', 'Jose Paulo siqueira', '9a8ad92c50cae39aa2c5604fd0ab6d8c', '38991123376', '321.952.321-23', '2002-02-18', 'M'),
       ('amanda.silva@gmail.com', 'Amanda Silva souza', 'f5302386464f953ed581edac03556e55', '14392911573', '123.877.776-11', '1993-02-19', 'F'),
       ('alexandremelo@gmail.com', 'Alexandre Queiroz Melo', '01fbdc44ef819db6273bc30965a23814', '21983711316', '543.456.333-54', '1992-07-15', 'F'),
       ('correamargarida@gmail.com', 'Margarida Correa', '372e25f23b5a8ae33c7ba203412ace30', '92993834491', '324.876.988-44', '2003-01-19', 'F'),
       ('wellxavier@gmail.com', 'Wellington Xavier', 'ddd5752b5fe66fd98fb9dcdee48b4473', '15993442243', '004.987.877-76', '1993-07-18', 'M');

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

insert into pedido (data_pedido, status_pedido, data_entrega, preco_total, frete_total, cliente_id, endereco_id, cartao_id, n_parcelas)
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
       (10, 10, 'Produto de qualidade', 4, '2022-07-04');;
```
# SELECTS
# *RELATÓRIO JOÃO MARCOS*

-- Nome cliente, nome impresso no cartão, Valor total da compra, Quantidade de parcelas e Valor por parcela
```sql
select c.nome, ct.nome, p.preco_total as total, p.n_parcelas as parcelas, p.preco_total / p.n_parcelas as valorParcelas
from cliente c
         join cartao ct
         join pedido p on c.id = ct.cliente_id and ct.id = p.cartao_id;
```

-- Nome cliente, nome impresso no cartão, valor gasto por cartão

```sql
select c.nome, ct.nome, nvl(sum(p.preco_total), 0) totalGasto
from cliente c
         join cartao ct on c.id = ct.cliente_id
         left join pedido p on ct.id = p.cartao_id
group by ct.nome
order by totalGasto desc;
```

-- Nome cliente, numero de compras, Últimos 12 meses
```sql
select c.nome, nvl(count(p.id), 0) comprasPeriodo12Meses
from cliente c
         left join pedido p on c.id = p.cliente_id
where p.data_pedido in (select p.data_pedido from pedido p where p.data_pedido > DATE_SUB(current_date(), INTERVAL 12 MONTH))
group by c.nome;
```

-- Nome do produto, prazo de entrega, produtos entregues em menos de 7 dias
```sql
select c.nome, p.id, p.data_pedido, p.data_entrega, day(p.data_entrega) - day(p.data_pedido) as prazoEntrega
from cliente c
         join pedido p on c.id = p.cliente_id
where p.data_entrega in (select p.data_entrega from pedido p where p.data_pedido < DATE_SUB(current_date(), INTERVAL 7 DAY));

