import { View } from "react-native";
import { Stack } from "expo-router";

export default function () {
	return (
		<View className={"flex-1 items-center justify-center"}>
			<Stack.Screen options={{ title: "Exercício 2.2" }} />
			<View className={"bg-[#50E3C2] w-20 h-20"} />
			<View className={"bg-[#4A90E2] w-20 h-20"} />
			<View className={"bg-[#9013FE] w-20 h-20"} />
		</View>
	);
}
