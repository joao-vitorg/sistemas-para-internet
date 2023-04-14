use eveniftm;

-- 1

-- A)
select a.titulo,
       a.tipo_atividade,
       c.nome_categoria,
       (select count(*) from inscricao i where i.cod_atividade = a.cod_atividade) inscritos
from atividade a
         join categoria c on c.cod_categoria = a.cod_categoria
where year(a.dt_realizacao) = 2023
order by 4 desc
limit 10;

-- B)
select u.nome_user, coalesce(floor(sum(a.carga_horaria) / 40) * 4, 0) pontos
from usuario u
         join inscricao i on u.cod_user = i.cod_user
         join atividade a on a.cod_atividade = i.cod_atividade and a.cod_categoria = 3
group by 1;

-- C)
select year(a.dt_realizacao) ano, month(a.dt_realizacao) mes, sum(a.valor_ingresso) valor_total
from atividade a
where a.cod_categoria <> 3
group by 1, 2;

-- D)
select distinct u.nome_user, timestampdiff(year, u.dt_nasc, now()) idade, u.sexo
from usuario u
         join inscricao i on u.cod_user = i.cod_user
         join atividade a on a.cod_atividade = i.cod_atividade and a.tipo_atividade = 'Mesa Redonda';

-- 2

-- A)
select a.titulo, c.nome_categoria, a.valor_ingresso
from atividade a
         join categoria c on c.cod_categoria = a.cod_categoria
where year(a.dt_realizacao) = 2023
  and a.valor_ingresso = (select max(a2.valor_ingresso) from atividade a2)
order by 3 desc;

-- B)
select u.nome_user, u.email
from usuario u
where u.cod_user not in (select i.cod_user from inscricao i where timestampdiff(month, i.dt_inscricao, now()) <= 3);

-- C)
select a.titulo, timestampdiff(day, a.dt_inicio_inscricao, a.dt_fim_inscricao) dias_inscricao, a.valor_ingresso
from atividade a
where a.cod_categoria in (select c.cod_categoria from categoria c where c.nome_categoria in ('Extensão', 'Pesquisa'))
  and timestampdiff(day, a.dt_realizacao, now()) < 0;

-- D)
select distinct u.nome_user, u.sexo, timestampdiff(year, u.dt_nasc, now()) idade
from usuario u
         join inscricao i on u.cod_user = i.cod_user
         join atividade a on a.cod_atividade = i.cod_atividade
where a.valor_ingresso > (select avg(a2.valor_ingresso) from atividade a2);

-- 3

(select u.nome_user,
        concat(sum(a.carga_horaria), ' Horas') carga_horaria_total,
        concat('Carga horária Suficiente')     situacao
 from usuario u
          join inscricao i on u.cod_user = i.cod_user
          join atividade a on a.cod_atividade = i.cod_atividade
 group by 1
 having carga_horaria_total >= 200)
union all
(select u.nome_user,
        concat(sum(a.carga_horaria), ' Horas') carga_horaria_total,
        concat('Carga horária insuficiente')   situacao
 from usuario u
          join inscricao i on u.cod_user = i.cod_user
          join atividade a on a.cod_atividade = i.cod_atividade
 group by 1
 having carga_horaria_total < 200);
