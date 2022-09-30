-- Exercício 2

select a.nome, mat, c.nome
from aluno a
         join curso c on c.cod_curso = a.cod_curso;

select a.nome, mat, c.nome
from aluno a
         join curso c on c.cod_curso = a.cod_curso
where entrada like '2016%';

select a.nome, c.nome, media
from aluno a
         join curso c on a.cod_curso = c.cod_curso
         join historico h on a.mat = h.mat;

select p.nome, d.nome
from alocacao a
         join disciplina d on d.cod_disc = a.cod_disc
         join professor p on p.cod_prof = a.cod_prof
         join turma t on t.cod_turma = a.cod_turma
where ano = 2016;

select d.nome, d2.nome
from pre_req p
         join disciplina d on d.cod_disc = p.cod_disc
         join disciplina d2 on d2.cod_disc = p.cod_disc_req;
