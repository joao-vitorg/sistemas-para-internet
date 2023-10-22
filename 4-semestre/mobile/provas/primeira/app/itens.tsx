import { FlatList, Pressable, Text, TextInput, View } from "react-native";
import { useEffect, useState } from "react";
import { SafeAreaView } from "react-native-safe-area-context";
import Remover from "../components/Remover";
import { Lance } from "./index";

interface Item {
	id: number;
	nome: string;
	valorMinimo: number;
	leilaoAberto: boolean;
	lanceVencedor: null | Lance;
}

export default function () {
	const [items, setItems] = useState(Array<Item>());
	const [nome, setNome] = useState("");
	const [valorMinimo, setValorMinimo] = useState("");
	const [refreshing, setRefreshing] = useState(false);

	const carregar = () => {
		setRefreshing(true);
		fetch("https://leilao-rest-api.herokuapp.com/itemdeleilao")
			.then((data) => data.json())
			.then((data) => setItems(data));
		setRefreshing(false);
	};

	useEffect(carregar, []);

	const cadastrar = () => {
		if (nome == "" || +valorMinimo <= 0) return;

		fetch("https://leilao-rest-api.herokuapp.com/itemdeleilao", {
			method: "POST",
			headers: {
				Accept: "application/json",
				"Content-Type": "application/json",
			},
			body: JSON.stringify({ nome, valorMinimo, leilaoAberto: true }),
		}).then((response) => {
			setItems([...items, { nome, valorMinimo: +valorMinimo } as Item]);
			setNome("");
			setValorMinimo("");
		});
	};

	const encerrar = (id: number) => {
		fetch("https://leilao-rest-api.herokuapp.com/itemdeleilao/" + id, {
			method: "PATCH",
			headers: {
				Accept: "application/json",
				"Content-Type": "application/json",
			},
		}).then((response) => {
			return response;
		});
	};

	return (
		<SafeAreaView className={"m-3 flex-1"}>
			<View className={"mb-2 space-y-3 rounded-xl bg-white p-3"}>
				<TextInput className={"rounded-lg border-2 p-2"} placeholder={"Nome"} value={nome} onChangeText={setNome} />
				<TextInput
					keyboardType={"numeric"}
					className={"rounded-lg border-2 p-2"}
					placeholder={"Valor mínimo"}
					value={valorMinimo}
					onChangeText={setValorMinimo}
				/>
				<Pressable className={"rounded-lg bg-blue-500 p-1"} onPress={cadastrar}>
					<Text className={"text-center text-lg font-bold text-white"}>Enviar</Text>
				</Pressable>
			</View>

			<FlatList
				data={items}
				onRefresh={carregar}
				refreshing={refreshing}
				renderItem={({ item }) => (
					<View className={"my-3 rounded-lg bg-white p-3 shadow"}>
						<Text>Id: {item.id}</Text>
						<Text>Nome: {item.nome}</Text>
						<Text>Valor mínimo R$:{item.valorMinimo}</Text>
						{item.lanceVencedor ? (
							<>
								<Text>Participante vencendor: {item.lanceVencedor.arrematante.nome}</Text>
								<Text>Lançe vencendor R$:{item.lanceVencedor.valor}</Text>
							</>
						) : null}
						<Text>Leilão aberto: {item.leilaoAberto ? "Sim" : "Não"}</Text>
						<View className={"flex-row space-x-2"}>
							<View className={"flex-1"}>
								<Remover id={item.id} slug={"itemdeleilao"} setItems={setItems} items={items} />
							</View>
							{!item.leilaoAberto ? (
								<Pressable className={"mt-3 flex-1 rounded-lg bg-blue-500 p-1"} onPress={() => encerrar(item.id)}>
									<Text className={"text-center text-lg font-bold text-white"}>Encerrar</Text>
								</Pressable>
							) : null}
						</View>
					</View>
				)}
			/>
		</SafeAreaView>
	);
}
