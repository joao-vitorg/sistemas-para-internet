use brasil;

# a. Listar em ordem decrescente os 10 estados com maior PIB (Top 10) em 2010.
select *
from estado
         join pib_estado pe on estado.id = pe.id_estado
where year(ano_pib) = 2010
order by valor_pib desc
limit 10;

# b. Para todos os estados, listar o nome do estado e sua média de PIB.
select nome, format(avg(valor_pib), 2)
from estado
         join pib_estado pe on estado.id = pe.id_estado
group by 1;

# c. Listar o ano e o PIB total do país para cada ano.
select ano_pib, format(sum(valor_pib), 2)
from pib_estado
group by 1;

# d. O nome do estado e o percentual de aumento (ou decréscimo)
# observado no PIB de 2015 em relação a 2010.
select e.nome, pe2015.valor_pib * 100 / pe2010.valor_pib - 100
from estado e
         join pib_estado pe2010 on e.id = pe2010.id_estado
         join pib_estado pe2015 on e.id = pe2015.id_estado
where pe2010.ano_pib = 2010
  and pe2015.ano_pib = 2015
group by 1;

# e. O nome do estado, quantidade de cidades, e o PIB por cidade
# (considerar a divisão igualitária entre as cidades do estado).
# Considerando somente o ano de 2017.
select estado.nome, count(*), pe.valor_pib / count(*)
from estado
         join cidade c on estado.id = c.id_estado
         join pib_estado pe on estado.id = pe.id_estado
where pe.ano_pib = 2017
group by 1;

# f. Listar o ano, a região, o valor do PIB correspondente a ela, bem como
# o menor e o maior valor do PIB para cada ano.
select ano_pib, regiao, format(sum(valor_pib), 2) pib, min(valor_pib), max(valor_pib)
from estado
         join pib_estado pe on estado.id = pe.id_estado
group by 1, 2;

# g. Considerando o PIB do ano de 2017, listar a região e o percentual de
# participação da região em relação ao PIB total do país.
select regiao, sum(pe.valor_pib) * 100 / (select sum(pe2.valor_pib) from pib_estado pe2 where pe2.ano_pib = 2017)
from estado
         join pib_estado pe on estado.id = pe.id_estado
where ano_pib = 2017
group by 1;

# h. Listar as informações de todos os estados que tiveram PIB superior ao
# PIB de Goiás no ano de 2015.
select *
from estado
         join pib_estado pe on estado.id = pe.id_estado
where ano_pib = 2015
  and valor_pib >= (select pe2.valor_pib from pib_estado pe2 where pe2.ano_pib = 2015 and pe2.id_estado = 9);

# i. Listar os estados que tiveram PIB abaixo da média no ano de 2017.
select *
from estado
         join pib_estado pe on estado.id = pe.id_estado
where ano_pib = 2017
  and valor_pib <= (select avg(pe2.valor_pib) from pib_estado pe2 where pe2.ano_pib = 2017);
