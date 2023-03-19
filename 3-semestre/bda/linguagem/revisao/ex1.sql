use the_game;

#1 A
select nickname, sexo, pontuacao, moedas, habilidade, dt_hora_aquisicao
from jogador
         join adquire_poder on jogador.cod_jogador = adquire_poder.cod_jogador
         join poder on adquire_poder.cod_poder = poder.cod_poder
order by dt_hora_aquisicao;

#1 B
select cod_partida, data_hora_inicio, data_hora_termino, pontos_obtidos, caracteristicas
from partida
         join cenario on partida.cod_cenario = cenario.cod_cenario
         join jogador on jogador.cod_jogador = partida.cod_jogador
where nome = 'Roberto Carlos';

# 1 C
select distinct jogador.*
from jogador
         join partida on jogador.cod_jogador = partida.cod_jogador
         join cenario on cenario.cod_cenario = partida.cod_cenario
where cenario.caracteristicas not like 'Terrestre';

#1 D
select distinct nome, sexo, year(dt_nasc), data_hora_inicio
from jogador
         join partida on partida.cod_jogador = jogador.cod_jogador
where hour(partida.data_hora_inicio) <= 18
  and month(partida.data_hora_inicio) = 6;

# 1 E
select habilidade
from jogador
         join adquire_poder on adquire_poder.cod_jogador = jogador.cod_jogador
         join poder on poder.cod_poder = adquire_poder.cod_poder
where nome = 'Maria Clara'
  and month(dt_hora_aquisicao) = 6
  and year(dt_hora_aquisicao) = 2021;


#2 A
select nickname, count(*)
from jogador
         join partida on partida.cod_jogador = jogador.cod_jogador
group by 1;

#2 B
select month(data_hora_inicio), day(data_hora_inicio), count(*)
from partida
where year(data_hora_inicio) = 2021
group by 1, 2;

#2 C
select nome, sum(pontos_obtidos)
from jogador
         join partida on partida.cod_jogador = jogador.cod_jogador
group by nome
having sum(pontos_obtidos) >= 200;

#2 D
select caracteristicas, count(*)
from cenario
         join partida on partida.cod_cenario = cenario.cod_cenario
group by 1;

#2 E
select nome, count(*)
from jogador
         join adquire_poder on adquire_poder.cod_jogador = jogador.cod_jogador
group by 1
order by 1 desc;
