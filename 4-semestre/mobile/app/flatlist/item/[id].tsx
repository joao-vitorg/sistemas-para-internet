import { Button, Image, Text, View } from "react-native";
import { useLocalSearchParams } from "expo-router";
import { itens } from "../../../assets/flatlist/itens";
import { useState } from "react";

export default function Page() {
	const { id } = useLocalSearchParams();
	const item = itens[+id];
	const [quantity, setQuantity] = useState(item.quantity);

	return (
		<View className={"flex-1 items-center p-10"}>
			<Image source={item.image} className={"h-80 w-full"} resizeMode="contain" />
			<Text className={"bold p-5 text-center text-4xl"}>
				{item.name} ({quantity})
			</Text>
			<View className={"h-20 flex-col justify-between"}>
				<Button onPress={() => setQuantity(++item.quantity)} title={"Adicionar ao carrinho"} />
				<Button
					onPress={() => setQuantity(--item.quantity)}
					color={"red"}
					disabled={quantity <= 0}
					title={"Remover do carrinho"}
				/>
			</View>
		</View>
	);
}
