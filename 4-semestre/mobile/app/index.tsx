import { View } from "react-native";
import { Link } from "expo-router";

export default function () {
	return (
		<View className={"flex-1 items-center justify-center"}>
			<Link href={"/introducao/"} className={"text-xl font-bold"}>
				Exercício 1
			</Link>
		</View>
	);
}
