-- Database professor com nome
create or replace database professor;
use professor;
create table professor
(
    id   int          not null primary key auto_increment,
    nome varchar(100) not null
);

-- Database contato com nome telefone, endereço e tipo com descrição
create or replace database contato;
use contato;
create table tipo
(
    id        int          not null primary key auto_increment,
    descricao varchar(100) not null
);
create table pessoa
(
    id       int          not null primary key auto_increment,
    nome     varchar(100) not null,
    telefone varchar(20)  not null,
    endereco varchar(100) not null,
    id_tipo  int          not null,
    foreign key (id_tipo) references tipo (id)
);

-- Database prédio
create database predio;
use predio;
create table proprietario
(
    id       int         not null primary key auto_increment,
    nome     varchar(50) not null,
    telefone varchar(20) not null
);
create table apartamento
(
    id              int         not null primary key auto_increment,
    numero          int         not null unique,
    qtd_quartos     int         not null,
    tipo_ocupacao   varchar(20) not null,
    id_proprietario int         not null,
    foreign key (id_proprietario) references proprietario (id)
);
