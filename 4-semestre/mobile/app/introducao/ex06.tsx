import { Image, View } from "react-native";
import { Stack } from "expo-router";

export default function () {
	return (
		<View className={"flex-1 gap-3 items-center justify-center"}>
			<Stack.Screen options={{ title: "Exercício 3" }} />
			<View className={"flex-row gap-3"}>
				<Image source={require("../../assets/introducao/placa1.png")} />
				<Image source={require("../../assets/introducao/placa2.png")} />
			</View>
			<View className={"flex-row gap-3"}>
				<Image source={require("../../assets/introducao/placa3.png")} />
				<Image source={require("../../assets/introducao/placa4.png")} />
			</View>
		</View>
	);
}
