import { FlatList, Image, Text, View } from "react-native";
import { itens } from "../../assets/flatlist/itens";

export default function Page() {
	return (
		<FlatList
			data={itens}
			renderItem={({ item }) => (
				<View className={"m-3 flex-1 space-y-3 rounded-lg bg-white p-3 shadow"}>
					<Image source={item.image} className={"h-40 w-full"} resizeMode="contain" />
					<Text className={"text-center text-xl text-zinc-500"}>{item.name}</Text>
					<Text className={"text-center text-xl text-zinc-500"}>{item.quantity} item(s)</Text>
				</View>
			)}
		/>
	);
}
