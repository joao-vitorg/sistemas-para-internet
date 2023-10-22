import { Pressable, Text } from "react-native";

interface props {
	id: number;
	slug: string;
	setItems: any;
	items: any;
}

export default function ({ id, slug, setItems, items }: props) {
	const remover = () => {
		fetch(`https://leilao-rest-api.herokuapp.com/${slug}/${id}`, {
			method: "DELETE",
			headers: {
				Accept: "application/json",
				"Content-Type": "application/json",
			},
		}).then((response) => {
			setItems(items.filter((item: { id: number }) => item.id != id));
		});
	};

	return (
		<Pressable className={"mt-3 rounded-lg bg-red-500 p-1"} onPress={remover}>
			<Text className={"text-center text-lg font-bold text-white"}>Remover</Text>
		</Pressable>
	);
}
