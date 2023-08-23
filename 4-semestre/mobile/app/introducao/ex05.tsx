import { View } from "react-native";
import { Stack } from "expo-router";

export default function () {
	return (
		<View className={"flex-1 justify-around"}>
			<Stack.Screen options={{ title: "Exercício 2.5" }} />
			<View className={"flex-row items-center justify-between"}>
				<View className={"bg-[#50E3C2] w-20 h-20"} />
				<View className={"bg-[#50E3C2] w-20 h-20"} />
				<View className={"bg-[#50E3C2] w-20 h-20"} />
			</View>
			<View className={"flex-row items-center justify-between"}>
				<View className={"bg-[#4A90E2] w-20 h-20"} />
				<View className={"bg-[#4A90E2] w-20 h-20"} />
				<View className={"bg-[#4A90E2] w-20 h-20"} />
			</View>
			<View className={"flex-row items-center justify-between"}>
				<View className={"bg-[#9013FE] w-20 h-20"} />
				<View className={"bg-[#9013FE] w-20 h-20"} />
				<View className={"bg-[#9013FE] w-20 h-20"} />
			</View>
		</View>
	);
}
