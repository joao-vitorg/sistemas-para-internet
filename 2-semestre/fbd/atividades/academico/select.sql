-- Exercício 2

select nome from disciplina where carga_hor > 100;

select * from aluno where nome like '%a %';

select mat, nome from aluno where nome like '%a';

select mat, nome from aluno where entrada like '2016%';

select media, cod_disc from historico where mat = 1001;
