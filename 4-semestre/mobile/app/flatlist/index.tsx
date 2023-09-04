import { FlatList, Image, ImageSourcePropType, Text, View } from "react-native";
import { Feather } from "@expo/vector-icons";

interface Item {
	image: ImageSourcePropType;
	name: string;
}

const data: Item[] = [
	{ image: require("../../assets/flatlist/01-tablelamps.png"), name: "Abajur" },
	{ image: require("../../assets/flatlist/02-ceilinglamps.png"), name: "Lâmpada" },
	{ image: require("../../assets/flatlist/03-sconces.png"), name: "Arante" },
	{ image: require("../../assets/flatlist/04-floorlamps.png"), name: "Luminaria de chão" },
	{ image: require("../../assets/flatlist/05-lightdecor.png"), name: "Luminaria decoração" },
	{ image: require("../../assets/flatlist/06-garlands.png"), name: "Luminaria jardim" },
];

export default function () {
	return (
		<View className={"flex-1 space-y-3 p-4"}>
			<View className={"flex-row items-center justify-between"}>
				<Text className={"text-3xl font-extrabold"}>Lighteria</Text>
				<View className={"items-center justify-center rounded-full bg-white p-3 shadow"}>
					<Feather name="shopping-bag" size={24} color="black" />
				</View>
			</View>

			<View className={"flex-row items-center space-x-4"}>
				<View className={"h-0.5 flex-1 bg-zinc-500"} />
				<Text className={"text-xl text-zinc-500"}>Categorias</Text>
				<View className={"h-0.5 flex-1 bg-zinc-500"} />
			</View>

			<FlatList
				data={data}
				numColumns={2}
				renderItem={({ item }) => (
					<View className={"m-3 flex-1 space-y-3 rounded-lg bg-white p-3 shadow"}>
						<Image source={item.image} className={"h-40 w-full"} resizeMode="contain" />
						<Text className={"text-center text-xl text-zinc-500"}>{item.name}</Text>
					</View>
				)}
			/>
		</View>
	);
}
