// Validação da tabela usuário
db.createCollection("user", {
	validator: {
		$jsonSchema: {
			bsonType: "object",
			additionalProperties: false,
			properties: {
				_id: { bsonType: "objectId" },
				first_name: { bsonType: "string" },
				last_name: { bsonType: "string" },
				email: { bsonType: "string" },
				cell_phone: { bsonType: "string" },
			},
		},
	},
});

// Validação da tabela projeto
db.createCollection("project", {
	validator: {
		$jsonSchema: {
			bsonType: "object",
			additionalProperties: false,
			properties: {
				_id: { bsonType: "objectId" },
				name: { bsonType: "string" },
				start_date: { bsonType: "date" },
				end_date: { bsonType: "date" },
				tasks: {
					bsonType: "array",
					items: {
						bsonType: "object",
						properties: {
							_id: { bsonType: "objectId" },
							title: { bsonType: "string" },
							description: { bsonType: "string" },
							start_date: { bsonType: "date" },
							deadline_date: { bsonType: "date" },
							priority: { bsonType: "int" },
							status: { bsonType: "string" },
							user: { bsonType: "objectId" },
							link: { bsonType: ["null", "objectId"] },
						},
					},
				},
			},
		},
	},
});
