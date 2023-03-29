drop database if exists mepoupe;
create database mepoupe;
use mepoupe;

create table cliente
(
    cod_cliente int auto_increment,
    nome        varchar(50),
    CPF         char(11),
    sexo        char(1),
    dt_nasc     date,
    telefone    char(15),
    email       varchar(100),
    primary key (cod_cliente)
);

create table conta_corrente
(
    cod_conta        int auto_increment,
    dt_hora_abertura date,
    saldo            numeric(9, 2),
    Status           varchar(15),
    cod_cliente      int,
    primary key (cod_conta),
    foreign key (cod_cliente) references cliente (cod_cliente)
);

create table registro_saque
(
    cod_saque   int auto_increment,
    cod_conta   int,
    dt_saque    date,
    valor_saque numeric(9, 2),
    primary key (cod_saque),
    foreign key (cod_conta) references conta_corrente (cod_conta)
);

insert into cliente (nome, CPF, sexo, dt_nasc, telefone, email)
values ('Bill Clinton', '12999786543', 'M', '1940-04-12', '11999786543', 'william@gmail.com'),
       ('Trump', '13999786544', 'M', '1942-05-10', '11999186543', 'trump@gmail.com'),
       ('Bolsonaro', '99487264826', 'M', '1972-05-10', '11993388447', 'bolsonaro@gmail.com'),
       ('Dilma', '93721172839', 'F', '1975-05-10', '11393859284', 'dilma@gmail.com'),
       ('Lula', '48729784938', 'M', '1952-05-10', '11943840284', 'lula@gmail.com'),
       ('Edson Angoti', '00000883627', 'M', '1900-05-10', '34887887899', 'angoti@iftm.edu.br');

insert into conta_corrente (dt_hora_abertura, saldo, Status, cod_cliente)
values ('2020-03-15', 50, 'Ativa', 1),
       ('2020-03-18', 500, 'Ativa', 2),
       ('2023-01-15', 1700, 'Ativa', 3),
       ('2023-02-18', 2300, 'Ativa', 4),
       ('2023-03-18', 7200, 'Ativa', 5),
       ('2023-01-01', 590000, 'Ativa', 5),
       ('2023-02-01', 7.23, 'Ativa', 6);

insert into registro_saque (cod_conta, dt_saque, valor_saque)
values (2, '2020-03-20', 20),
       (2, '2020-04-20', 80),
       (3, '2023-01-20', 3000),
       (4, '2023-02-20', 5000),
       (5, '2023-03-20', 1000);

create table registro_deposito
(
    cod_deposito   int auto_increment,
    cod_conta      int,
    dt_deposito    date,
    valor_deposito numeric(9, 2),
    primary key (cod_deposito),
    foreign key (cod_conta) references conta_corrente (cod_conta)
);

insert into registro_deposito (cod_conta, dt_deposito, valor_deposito)
values (2, '2020-04-22', 800),
       (2, '2020-03-19', 40),
       (3, '2023-01-19', 1000),
       (4, '2023-02-22', 3000),
       (5, '2023-03-22', 5000),
       (6, '2023-01-01', 590000);
