import { View } from "react-native";
import { Link } from "expo-router";

export default function () {
	return (
		<View className={"flex-1 items-center justify-center"}>
			<View className={"space-y-2"}>
				<Link href={"/introducao/"} className={"text-xl font-bold"}>
					Introdução
				</Link>
				<Link href={"/flatlist/"} className={"text-xl font-bold"}>
					FlatList
				</Link>
			</View>
		</View>
	);
}
