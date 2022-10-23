create database clinica;
use clinica;

-- Criação de table

create table medico
(
    codm          int primary key auto_increment,
    nomem         varchar(50) not null,
    especialidade varchar(30) not null,
    sexo          char        not null,
    dt_nasc       date        not null
);

create table paciente
(
    codp     int primary key auto_increment,
    nomep    varchar(50) not null,
    dt_nasc  date        not null,
    problema varchar(50) not null,
    sexo     char        not null
);

create table consulta
(
    codc           int primary key auto_increment,
    codm           int           null,
    codp           int           null,
    dt_consulta    date          null,
    hora_consulta  time          null,
    valor_consulta decimal(9, 2) null,
    foreign key (codm) references medico (codm),
    foreign key (codp) references paciente (codp)
);

-- Incerção de dados

insert into medico (nomem, especialidade, sexo, dt_nasc)
values ('Claudia Avila', 'Ginecologista', 'F', '1960-08-10'),
       ('Claudio Felix', 'Oftalmologista', 'M', '1970-01-02'),
       ('Luciano Fernandes', 'Ginecologista', 'M', '1980-03-04'),
       ('Manoel Jose', 'Cardiologista', 'M', '1964-11-15'),
       ('Marcos Paulo', 'Neurologista', 'M', '1975-07-12'),
       ('Maria Jose', 'Cardiologista', 'F', '1974-12-13'),
       ('Roberto Carlos', 'Neuropediatra', 'M', '1977-06-05');

insert into paciente (nomep, dt_nasc, problema, sexo)
values ('Maria Paula', '1960-08-19', 'Cardiaco', 'F'),
       ('Maria do Carmo', '1979-03-10', 'Hipertensao', 'F'),
       ('Luiz Inacio', '1950-01-12', 'Diabetes', 'M'),
       ('Carolina Freitas', '1985-11-05', 'Miopia', 'F'),
       ('Luiz Marcelo', '1973-05-15', 'Cardiaco', 'M'),
       ('Luciano Fernandes', '1980-03-04', 'Cardiaco', 'M');

insert into consulta (codm, codp, dt_consulta, hora_consulta, valor_consulta)
values (1, 2, '2017-06-10', '16:00:00', 150.00),
       (3, 1, '2017-06-15', '14:00:00', 180.00),
       (3, 2, '2017-06-22', '14:00:00', 150.00),
       (1, 1, '2017-06-25', '16:00:00', 150.00),
       (4, 5, '2017-06-27', '15:00:00', 130.00),
       (2, 4, '2017-07-10', '13:00:00', 180.00),
       (1, 2, '2017-07-12', '15:00:00', 180.00),
       (4, 5, '2017-07-14', '14:00:00', 150.00),
       (5, 3, '2017-07-17', '16:30:00', 130.00),
       (5, 2, '2017-07-20', '15:00:00', 180.00),
       (6, 4, '2017-07-23', '14:00:00', 150.00),
       (6, 6, '2017-07-25', '15:00:00', 140.00),
       (3, 2, '2017-08-22', '13:00:00', 180.00),
       (1, 1, '2017-08-25', '13:00:00', 180.00),
       (4, 5, '2018-01-22', '13:00:00', 250.00),
       (5, 3, '2018-01-25', '13:00:00', 230.00),
       (6, 4, '2019-06-22', '13:00:00', 300.00),
       (1, 2, '2019-06-25', '13:00:00', 300.00);
