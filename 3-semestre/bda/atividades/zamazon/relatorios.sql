use zamazon;

-- Letra a) Elabore um relatório contendo a situação da meta em cada mês, levando em consideração que, para que a meta seja alcançada,
-- é necessário que a loja venda mais do que a média de vendas de todos os meses anteriores.

(select vrv.nome, vrv.ano, vrv.mes, vrv.ganho_total, concat('Bateu a meta') situacao
 from vw_vendas vrv
 where ganho_total >=
       coalesce((select avg(v.ganho_total) from vw_vendas v where v.id = vrv.id and ((v.ano < vrv.ano) or (vrv.ano = v.ano and v.mes < vrv.mes))), 0))
union all
(select vrv.nome, vrv.ano, vrv.mes, vrv.ganho_total, concat('Não bateu a meta') situacao
 from vw_vendas vrv
 where ganho_total <
       coalesce((select avg(v.ganho_total) from vw_vendas v where v.id = vrv.id and ((v.ano < vrv.ano) or (vrv.ano = v.ano and v.mes < vrv.mes))),
                0));
