import { FlatList, Image, Pressable, Text, View } from "react-native";
import { Feather } from "@expo/vector-icons";
import { Link } from "expo-router";
import { itens } from "../../assets/flatlist/itens";

export default function () {
	return (
		<View className={"flex-1 space-y-3 p-4"}>
			<View className={"flex-row items-center justify-between"}>
				<Text className={"text-3xl font-extrabold"}>Lighteria</Text>
				<Link href={"/flatlist/cart"} className={"items-center justify-center rounded-full bg-white p-3 shadow"}>
					<Feather name="shopping-bag" size={24} color="black" />
				</Link>
			</View>

			<View className={"flex-row items-center space-x-4"}>
				<View className={"h-0.5 flex-1 bg-zinc-500"} />
				<Text className={"text-xl text-zinc-500"}>Categorias</Text>
				<View className={"h-0.5 flex-1 bg-zinc-500"} />
			</View>

			<FlatList
				data={itens}
				numColumns={2}
				renderItem={({ item, index }) => (
					<Link href={`/flatlist/item/${index}`} asChild>
						<Pressable className={"m-3 flex-1 space-y-3 rounded-lg bg-white p-3 shadow"}>
							<Image source={item.image} className={"h-40 w-full"} resizeMode="contain" />
							<Text className={"text-center text-xl text-zinc-500"}>{item.name}</Text>
						</Pressable>
					</Link>
				)}
			/>
		</View>
	);
}
