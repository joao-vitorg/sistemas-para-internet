import { FlatList, Text, View } from "react-native";
import { useEffect, useState } from "react";

interface Sheet {
	titulo: string;
	data: string;
}

export default function () {
	const [atividades, setAtividades] = useState(Array<Sheet>());

	useEffect(() => {
		fetch(
			"https://sheets.googleapis.com/v4/spreadsheets/12Caig6R9SwLTXKnHK9wFr6RaW_qctI3OkuCXvRSh9gY/values/Atividades?valueRenderOption=FORMATTED_VALUE&key=AIzaSyA_OCg2gjmuCD3U0UcnpBkBNTKm6-PxbOU",
		)
			.then((data) => data.json())
			.then((data) =>
				setAtividades(
					data.values
						.map((x: any[]) => {
							return { titulo: x[1], data: x[4] };
						})
						.splice(1),
				),
			);
	}, []);

	return (
		<View>
			<FlatList
				data={atividades}
				renderItem={({ item }) => (
					<View className={"m-2 space-y-5 rounded bg-blue-500 p-3"}>
						<Text className={"text-base font-bold text-white"}>{item.titulo}</Text>
						<Text className={"text-base font-bold text-green-400"}>{item.data}</Text>
					</View>
				)}
			/>
		</View>
	);
}
