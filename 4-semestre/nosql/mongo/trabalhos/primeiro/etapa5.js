// 1. Altera o usuario responsavel pela tarefa
db.project.updateOne(
	{ "tasks.title": "tabesco territo adeptio" },
	{
		$set: {
			"tasks.$.user": ObjectId("65442e6c91637644bd6b9470"),
		},
	},
);

// 2. Dilata o prazo de entrega em 2 dias
db.project.updateOne(
	{ "tasks.title": "conspergo animi claudeo" },
	{
		$set: {
			"tasks.$.deadline_date": new Date("2024-02-20T00:00:00Z"),
		},
	},
);

// 3. Muda o status de "Em andamento" para "Concluido"
db.project.updateOne(
	{ "tasks.title": "voluptate ago aut" },
	{
		$set: {
			"tasks.$.status": "Concluido",
		},
	},
);

// 4. Adiciona uma nova tarefa ao projeto
db.project.updateOne(
	{ _id: ObjectId("65442f8c91637644bd6b9473") },
	{
		$push: {
			tasks: {
				title: "nova tarefa",
				description: "nova tarefa",
				status: "Em andamento",
				start_date: new Date(),
				deadline_date: new Date("2023-12-20T00:00:00Z"),
				user: ObjectId("65442e6c91637644bd6b946c"),
			},
		},
	},
);

// 5. Altera o telefone do usuario
db.user.updateOne(
	{ _id: ObjectId("65442e6c91637644bd6b946e") },
	{
		$set: {
			cell_phone: "34999999999",
		},
	},
);
