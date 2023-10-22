import { FlatList, Pressable, Text, TextInput, View } from "react-native";
import { useEffect, useState } from "react";
import { SafeAreaView } from "react-native-safe-area-context";
import Remover from "../components/Remover";

export interface Participante {
	id: number;
	nome: string;
	cpf: string;
}

export default function () {
	const [participantes, setParticipantes] = useState(Array<Participante>());
	const [nome, setNome] = useState("");
	const [cpf, setCpf] = useState("");
	const [refreshing, setRefreshing] = useState(false);

	const carregar = () => {
		setRefreshing(true);
		fetch("https://leilao-rest-api.herokuapp.com/participante")
			.then((data) => data.json())
			.then((data) => setParticipantes(data));
		setRefreshing(false);
	};

	useEffect(() => carregar, []);

	const cadastrar = () => {
		if (nome == "" || cpf == "") return;

		fetch("https://leilao-rest-api.herokuapp.com/participante", {
			method: "POST",
			headers: {
				Accept: "application/json",
				"Content-Type": "application/json",
			},
			body: JSON.stringify({ nome, cpf }),
		}).then((response) => {
			setParticipantes([...participantes, { nome, cpf } as Participante]);
			setNome("");
			setCpf("");
		});
	};

	return (
		<SafeAreaView className={"m-3 flex-1"}>
			<View className={"mb-2 space-y-3 rounded-xl bg-white p-3"}>
				<TextInput className={"rounded-lg border-2 p-2"} placeholder={"Nome"} value={nome} onChangeText={setNome} />
				<TextInput
					className={"rounded-lg border-2 p-2"}
					placeholder={"CPF"}
					value={cpf}
					keyboardType={"numeric"}
					onChangeText={setCpf}
				/>
				<Pressable className={"rounded-lg bg-blue-500 p-1"} onPress={cadastrar}>
					<Text className={"text-center text-lg font-bold text-white"}>Enviar</Text>
				</Pressable>
			</View>

			<FlatList
				data={participantes}
				refreshing={refreshing}
				onRefresh={carregar}
				renderItem={({ item }) => (
					<View className={"my-3 rounded-lg bg-white p-3 shadow"}>
						<Text>Id: {item.id}</Text>
						<Text>Nome: {item.nome}</Text>
						<Text>CPF: {item.cpf}</Text>
						<Remover id={item.id} slug={"participante"} setItems={setParticipantes} items={participantes} />
					</View>
				)}
			/>
		</SafeAreaView>
	);
}
