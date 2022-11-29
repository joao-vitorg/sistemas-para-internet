-- EX2 João Vitor Gomes de Souza
use voebem;

insert into companhia(nome_comp, sigla)
VALUES ('TAM linhas aéreas', 'TAM'),
       ('GOL linhas aéreas', 'GOL'),
       ('TAP linhas aéreas', 'TAP');

insert into piloto (nome_piloto, salario, gratidicacao, cod_cia, pais, email)
values ('Roberto Carlos', 5000, 2000, 1, 'Brasil', 'beto@gmail.com'),
       ('Rafael Marinho', 6000, 3000, 2, 'Brasil', 'rafa@gmail.com'),
       ('Marcos Jose', 4000, 1000, 3, 'Brasil', 'marcos@gmail.com'),
       ('Daniel Oliveira', 4000, 1500, 1, 'Brasil', 'dani@gmail.com');

insert into aeroporto (codigo_aeroporto, nome_aeroporto, cidade_aeroporto, pais)
values ('001', 'Tancredo Neves', 'Confins', 'Brasil'),
       ('002', 'Internacional de São Paulo - Guarulhos', 'Guarulhos', 'Brasil'),
       ('003', 'Cesar Bombonato', 'Uberlândia', 'Brasil');

insert into voo (codigo_voo, aeroporto_origem, aeroporto_destimo, hora)
values ('A200', '001', '002', '07:00'),
       ('A100', '002', '003', '12:00'),
       ('A300', '003', '001', '23:00'),
       ('A400', '003', '002', '16:00'),
       ('A500', '001', '003', '07:00'),
       ('A600', '001', '002', '11:00');

insert into escala (codigo_voo, data_voo, codigo_piloto, aviao)
values ('A200', '2018-05-12', 1, 'Boeing 385'),
       ('A100', '2018-05-12', 4, 'Boeing 385'),
       ('A300', '2018-05-13', 2, 'AirBus 232'),
       ('A400', '2018-07-14', 3, 'AirBus 123'),
       ('A500', '2018-07-15', 1, 'AirBus 123'),
       ('A600', '2018-07-17', 2, 'Boeing 385');
