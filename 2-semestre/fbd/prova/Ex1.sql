-- EX1 João Vitor Gomes de Souza
create database voebem;
use voebem;

create table companhia
(
    cod_cia   int primary key auto_increment,
    nome_comp varchar(30),
    sigla     varchar(5)
);

create table aeroporto
(
    codigo_aeroporto varchar(3) primary key,
    nome_aeroporto   varchar(100),
    cidade           varchar(50),
    pais             varchar(15)
);

create table piloto
(
    codigo_piloto int primary key auto_increment,
    nome_piloto   varchar(50),
    salario       numeric(9, 2),
    gratidicacao  numeric(9, 2),
    cod_cia       int,
    pais          varchar(15),
    foreign key (cod_cia) references companhia (cod_cia)
);

create table voo
(
    codigo_voo        varchar(6) primary key,
    aeroporto_origem  varchar(3),
    aeroporto_destimo varchar(3),
    hora              time,
    foreign key (aeroporto_origem) references aeroporto (codigo_aeroporto),
    foreign key (aeroporto_destimo) references aeroporto (codigo_aeroporto)
);

create table escala
(
    codigo_voo    varchar(6),
    data_voo      date,
    codigo_piloto int,
    aviao         varchar(30),
    primary key (codigo_voo, data_voo),
    foreign key (codigo_voo) references voo (codigo_voo),
    foreign key (codigo_piloto) references piloto (codigo_piloto)
);

alter table piloto
    add email varchar(30);

alter table aeroporto
    CHANGE cidade cidade_aeroporto varchar(50);

alter table companhia
    change nome_comp nome_comp varchar(40);
