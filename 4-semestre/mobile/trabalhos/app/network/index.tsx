import { FlatList, Text, View } from "react-native";
import { useEffect, useState } from "react";

interface Aluno {
	nota: number;
	nome: string;
}

export default function () {
	const [alunos, setAlunos] = useState(Array<Aluno>());

	useEffect(() => {
		fetch("https://6501a5d8736d26322f5c1121.mockapi.io/prova/notas")
			.then((data) => data.json())
			.then((data) => setAlunos(data));
	}, []);

	return (
		<View>
			<FlatList
				data={alunos}
				renderItem={({ item }) => (
					<View>
						<View className={"h-6 w-6 rounded-full " + (item.nota < 6 ? "bg-red-500" : "bg-blue-500")} />
						<Text style={{ flex: 1 }}>{item.nome}</Text>
						<Text>{item.nota}</Text>
					</View>
				)}
			/>
		</View>
	);
}
