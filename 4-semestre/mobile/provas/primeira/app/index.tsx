import { FlatList, Pressable, Text, TextInput, View } from "react-native";
import { useEffect, useState } from "react";
import { Participante } from "./participantes";
import { SafeAreaView } from "react-native-safe-area-context";
import Remover from "../components/Remover";

export interface Lance {
	id: number;
	valor: number;
	arrematante: Participante;
}

export default function () {
	const [items, setItems] = useState(Array<Lance>());
	const [valor, setValor] = useState("");
	const [itemId, setItemId] = useState("");
	const [arrematanteId, setArrematanteId] = useState("");
	const [refreshing, setRefreshing] = useState(false);

	const carregar = () => {
		setRefreshing(true);
		fetch("https://leilao-rest-api.herokuapp.com/lance")
			.then((data) => data.json())
			.then((data) => setItems(data));
		setRefreshing(false);
	};

	useEffect(() => carregar, []);

	const cadastrar = () => {
		if (valor == "" || +arrematanteId <= 0) return;

		fetch("https://leilao-rest-api.herokuapp.com/itemdeleilao/" + itemId, {
			method: "PUT",
			headers: {
				Accept: "application/json",
				"Content-Type": "application/json",
			},
			body: JSON.stringify({ valor, arrematante: { id: arrematanteId } }),
		}).then(() => {
			carregar();
			setValor("");
			setItemId("");
			setArrematanteId("");
		});
	};

	return (
		<SafeAreaView className={"m-3 flex-1"}>
			<View className={"mb-2 space-y-3 rounded-xl bg-white p-3"}>
				<TextInput
					className={"rounded-lg border-2 p-2"}
					placeholder={"Item id"}
					keyboardType={"numeric"}
					value={itemId}
					onChangeText={setItemId}
				/>
				<TextInput
					className={"rounded-lg border-2 p-2"}
					placeholder={"Arrematante id"}
					keyboardType={"numeric"}
					value={arrematanteId}
					onChangeText={setArrematanteId}
				/>
				<TextInput
					keyboardType={"numeric"}
					className={"rounded-lg border-2 p-2"}
					placeholder={"Valor"}
					value={valor}
					onChangeText={setValor}
				/>
				<Pressable className={"rounded-lg bg-blue-500 p-1"} onPress={cadastrar}>
					<Text className={"text-center text-lg font-bold text-white"}>Enviar</Text>
				</Pressable>
			</View>

			<FlatList
				data={items}
				refreshing={refreshing}
				onRefresh={carregar}
				renderItem={({ item }) => (
					<View className={"my-3 rounded-lg bg-white p-3 shadow"}>
						<Text>Arrematante: {item.arrematante.nome}</Text>
						<Text>Valor R$:{item.valor}</Text>
						<Remover id={item.id} slug={"lance"} setItems={setItems} items={items} />
					</View>
				)}
			/>
		</SafeAreaView>
	);
}
