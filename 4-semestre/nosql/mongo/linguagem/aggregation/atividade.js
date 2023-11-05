// ================================================================================================
// 1. Qual é o valor total de vendas por cliente
// ================================================================================================
db.pedidos.aggregate({
	$group: {
		// agrupa por cliente e soma o valor total
		_id: "$cliente", // agrupa por cliente
		valor_total: { $sum: "$valor_total" }, // soma o valor total
	},
});

// ================================================================================================
// 2. Quais são os produtos mais vendidos
// ================================================================================================
db.pedidos.aggregate([
	{
		$unwind: "$itens", // desmembra os itens
	},
	{
		$group: {
			// agrupa por produto e soma a quantidade
			_id: "$itens.produto", // agrupa por produto
			total_vendido: { $sum: "$itens.quantidade" }, // soma a quantidade
		},
	},
	{
		$sort: { total_vendido: -1 }, // ordena por quantidade vendida (decrescente)
	},
]);

db.pedidos.aggregate([
	{
		$group: {
			// agrupa por mês e calcula a média do valor total
			_id: { $dateToString: { format: "%Y-%m", date: "$data_pedido" } }, // agrupa por mês
			valor_medio: { $avg: "$valor_total" }, // calcula a média do valor total
		},
	},
]);

// ================================================================================================
// 4. Quais são os clientes que fizeram pedidos em mais de um mês
// ================================================================================================
db.pedidos.aggregate([
	{
		$group: {
			// agrupa por cliente e mês
			_id: {
				cliente: "$cliente", // agrupa por cliente
				mes: { $month: "$data_pedido" }, // agrupa por mês
			},
		},
	},
	{
		$group: {
			// agrupa novamente para contar os meses
			_id: "$_id.cliente", // agrupa por cliente
			meses: { $push: "$_id.mes" }, // cria um array com os meses
		},
	},
	{
		$project: {
			// projeta o resultado
			_id: 1, // mantém o id
			total_meses: { $size: "$meses" }, // calcula o tamanho do array
		},
	},
	{
		$match: {
			// filtra
			total_meses: { $gt: 1 }, // filtra os clientes que fizeram pedidos em mais de um mês
		},
	},
]);

// ================================================================================================
// 5. Quantos pedidos foram feitos em cada dia da semana (segunda-feira, terça-feira, etc.)
// ================================================================================================
db.pedidos.aggregate([
	{
		$group: {
			// agrupa por dia da semana e conta os pedidos
			_id: { $dayOfWeek: "$data_pedido" }, // agrupa por dia da semana
			total_pedidos: { $sum: 1 }, // conta os pedidos
		},
	},
	{
		$project: {
			_id: 0, // remove o id
			dia_da_semana: {
				// cria um campo com o dia da semana
				$switch: {
					// traduz o dia da semana
					branches: [
						{ case: { $eq: ["$_id", 1] }, then: "Domingo" },
						{ case: { $eq: ["$_id", 2] }, then: "Segunda-feira" },
						{ case: { $eq: ["$_id", 3] }, then: "Terça-feira" },
						{ case: { $eq: ["$_id", 4] }, then: "Quarta-feira" },
						{ case: { $eq: ["$_id", 5] }, then: "Quinta-feira" },
						{ case: { $eq: ["$_id", 6] }, then: "Sexta-feira" },
						{ case: { $eq: ["$_id", 7] }, then: "Sábado" },
					],
					default: "Desconhecido",
				},
			},
			total_pedidos: 1, // mantém o total de pedidos
		},
	},
]);

// ================================================================================================
// 6. Qual é a média de preço unitário por produto?
// ================================================================================================
db.pedidos.aggregate([
	{
		$unwind: "$itens", // desmembra os itens
	},
	{
		$group: {
			// agrupa por produto e calcula a média do preço unitário
			_id: "$itens.produto", // agrupa por produto
			media_preco_unitario: { $avg: "$itens.preco_unitario" }, // calcula a média do preço unitário
		},
	},
	{
		$sort: { media_preco_unitario: -1 }, // ordena por preço unitário (decrescente)
	},
]);

// ================================================================================================
// 7. Quais são os clientes que fizeram o pedido de maior valor?
// ================================================================================================
db.pedidos.aggregate([
	{
		$group: {
			// agrupa por cliente e calcula o maior valor do pedido
			_id: "$cliente", // agrupa por cliente
			maior_valor_pedido: { $max: "$valor_total" }, // calcula o maior valor do pedido
		},
	},
	{
		$match: {
			// filtra
			maior_valor_pedido: { $gte: 0 }, // filtra os clientes que fizeram pedidos
		},
	},
]);
