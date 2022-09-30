create database academico;
use academico;

-- Criar tabelas

create table curso
(
    cod_curso int primary key,
    nome      varchar(100),
    sigla     varchar(10)
);

create table aluno
(
    mat       int primary key,
    entrada   char(6),
    nome      varchar(100),

    cod_curso int,
    foreign key (cod_curso) references curso (cod_curso)
);

create table disciplina
(
    cod_disc  int primary key,
    nome      varchar(100),
    sigla     varchar(10),
    carga_hor int
);

create table professor
(
    cod_prof int primary key,
    nome     varchar(100)
);

create table turma
(
    cod_turma int primary key,
    ano       char(4),
    sem       char(1)
);

create table alocacao
(
    cod_turma int,
    cod_disc  int,
    cod_prof  int,
    foreign key (cod_turma) references turma (cod_turma),
    foreign key (cod_disc) references disciplina (cod_disc),
    foreign key (cod_prof) references professor (cod_prof)
);

create table historico
(
    media     double,

    cod_turma int,
    mat       int,
    cod_disc  int,
    foreign key (cod_turma) references turma (cod_turma),
    foreign key (mat) references aluno (mat),
    foreign key (cod_disc) references disciplina (cod_disc)
);

create table pre_req
(
    cod_disc     int,
    cod_disc_req int,
    foreign key (cod_disc) references disciplina (cod_disc),
    foreign key (cod_disc_req) references disciplina (cod_disc)
);

-- Inserir dados

insert into curso(cod_curso, nome, sigla)
VALUES (1, 'Sistemas para Internet', 'TSPI'),
       (2, 'Licenciatura em Computação', 'LCOMP');

insert into aluno(mat, nome, entrada, cod_curso)
values (1001, 'Paulo Silva', '2016_1', 1),
       (1002, 'Carla Marins', '2016_2', 1),
       (1003, 'Marcos Ferreira', '2017_1', 2);

insert into disciplina(cod_disc, nome, sigla, carga_hor)
values (1, 'Lógica', 'Log', 105),
       (2, 'Algoritmos', 'Alg', 80),
       (3, 'Banco de Dados 1', 'BD1', 75),
       (4, 'Programação Orientada a Objetos', 'POO', 120);

insert into professor(cod_prof, nome)
values (1, 'Clarimundo'),
       (2, 'Mateus'),
       (3, 'Cibele');

insert into turma (cod_turma, ano, sem)
values (44, '2016', '1'),
       (46, '2016', '1'),
       (47, '2016', '2'),
       (48, '2017', '1');

insert into alocacao (cod_turma, cod_disc, cod_prof)
values (44, 1, 1),
       (46, 3, 2),
       (46, 2, 1),
       (47, 3, 3),
       (48, 4, 1);

insert into historico (cod_turma, mat, cod_disc, media)
values (44, 1001, 1, 6),
       (46, 1001, 2, 5.5),
       (47, 1002, 3, 7);

insert into pre_req (cod_disc, cod_disc_req)
values (2, 1),
       (4, 2);
