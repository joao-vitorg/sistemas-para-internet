use zamazon;

-- Questão 4) (Subconsultas)

-- Letra a) A equipe de vendas pediu para que você faça um relatório com a taxa de comentários que cada produto teve.

-- Taxa de comentários por pedidos
select p.nome,
       concat(round(((select count(*) from comentario c where c.produto_id = p.id_produto) * 100) /
                    (select count(pp.pedido_id) from pedido_produto pp where pp.produto_id = p.id_produto), 2), '%') taxa
from produto p;

-- Letra b) A equipe de marketing das lojas solicitou que você prepare um relatório que apresente os produtos que
-- estão na lista de compras dos clientes, bem como os seus endereços de e-mail, a fim de enviar uma campanha
-- publicitária personalizada para cada um.

-- Emails dos clientes que possuem itens em seus carrinhos
select (select (select nome from loja l where l.id_loja = p.loja_id) from produto p where p.id_produto = c.produto_id) loja,
       (select nome from produto p where p.id_produto = c.produto_id)                                                  produto,
       (select nome from cliente c2 where c2.id_cliente = c.cliente_id)                                                cliente,
       (select email from cliente c2 where c2.id_cliente = c.cliente_id)                                               email
from carrinho c;


-- Questão 5) (Junção interna e externa)

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
