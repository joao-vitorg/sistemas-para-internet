// Usuário
user = {
	first_name: "João",
	last_name: "Silva",
	email: "joao@test.com",
	cell_phone: "999999999",
};

// Projeto e tareja
project = {
	name: "Projeto 1",
	start_date: new Date(),
	end_date: new Date("2023-12-31"),
	tasks: [
		{
			title: "Tarefa 1",
			description: "Descrição da tarefa 1",
			start_date: new Date("2023-01-01"),
			deadline_date: new Date("2023-01-10"),
			priority: 1,
			status: "Em andamento",
			user: ObjectId("653eff206d7820336ef9ca5b"), // Referência ao usuário
			link: null, // Caso haja referência a outra tarefa
		},
	],
};
