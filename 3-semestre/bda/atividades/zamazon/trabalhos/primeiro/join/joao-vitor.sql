use zamazon;

-- Letra a) Faça um relatório mostrando quantos reais cada loja iria receber caso todos os clientes finalizassem as suas compras.

-- Tudo que a loja iria receber caso todos os clientes efetuarem a compra
select l.nome, coalesce((sum(p.preco * c.quantidade)), 0) a_receber
from produto p
         left join carrinho c on p.id_produto = c.produto_id
         join loja l on l.id_loja = p.loja_id
group by l.id_loja;

-- Letra b) Escreva um relatório com o total ganho de cada loja em cada produto

-- Ganho por loja e produto
select l.nome loja, p.nome produto, coalesce(sum(pp.preco * pp.quantidade), 0) total
from loja l
         join produto p on l.id_loja = p.loja_id
         left join pedido_produto pp on p.id_produto = pp.produto_id
group by 1, 2;
