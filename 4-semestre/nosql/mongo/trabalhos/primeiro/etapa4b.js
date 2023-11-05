// 1. Projetos que começaram antes de 2023-10-27
db.project.find({ start_date: { $lte: new Date("2023-10-27") } });

// 2. Todos os projetos que possuem tarefas em progresso
db.project.find({ tasks: { $elemMatch: { status: "Em Progresso" } } });

// 3. Todos os projetos que possuem tarefas concluidas
db.project.find({ tasks: { $elemMatch: { status: "Concluida" } } });

// 4. Todos os projetos que possuem tarefas pendentes
db.project.find({ tasks: { $elemMatch: { status: "Pendente" } } });

// 5. Todos os projetos que possuem tarefas em que o prazo de entrega é menor ou igual a 2023-10-27
db.project.find({ tasks: { $elemMatch: { deadline_date: { $lte: new Date("2023-10-27") } } } });

// 6. Todos os projetos que possuem tarefas em que o prazo de entrega é maior ou igual a 2023-10-27
db.project.find({ tasks: { $elemMatch: { deadline_date: { $gte: new Date("2023-10-27") } } } });

// 7. Todos os projetos que possuem tarefas em que o prazo de entrega é menor ou igual a 2023-10-27 e que estão em progresso
db.project.find({ tasks: { $elemMatch: { deadline_date: { $lte: new Date("2023-10-27") }, status: "Em Progresso" } } });

// 8. Todos os projetos que possuem tarefas em que o prazo de entrega é maior ou igual a 2023-10-27 e que estão em progresso
db.project.find({ tasks: { $elemMatch: { deadline_date: { $gte: new Date("2023-10-27") }, status: "Em Progresso" } } });

// 9. Todos os projetos que possuem tarefas com prioridade maior ou igual a 3
db.project.find({ tasks: { $elemMatch: { priority: { $gte: 3 } } } });

// 10. Todos os usuarioss que possuem o numero de telefone com o ddd 11
db.user.find({ cell_phone: { $regex: /^11/ } });

// 11. Todos os usuarioss que possuem o numero de telefone com o ddd 11 e que possuem o nome que começa com a letra A
db.user.find({ cell_phone: { $regex: /^11/ }, first_name: { $regex: /^A/ } });

// 12. Todos os usuarios que possuem o nome que começa com a letra J e que possuem o sobrenome que começa com a letra V
db.user.find({ first_name: { $regex: /^J/ }, last_name: { $regex: /^V/ } });

// 13. Todos os usuarios que usam o dominio @gmail
db.user.find({ email: { $regex: /@gmail/ } });

// 14. Todos os usuarios que usam o dominio @gmail e que possuem o nome que começa com a letra A
db.user.find({ email: { $regex: /@gmail/ }, first_name: { $regex: /^A/ } });

// 15. Todos os usuarios que usam o dominio @gmail e que possuem o nome que começa com a letra A e que possuem o sobrenome que começa com a letra V
db.user.find({ email: { $regex: /@gmail/ }, first_name: { $regex: /^A/ }, last_name: { $regex: /^V/ } });
