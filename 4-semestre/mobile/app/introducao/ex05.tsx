import { View } from "react-native";

export default function () {
	return (
		<View className={"flex-1 justify-around"}>
			<View className={"flex-row items-center justify-between"}>
				<View className={"h-20 w-20 bg-[#50E3C2]"} />
				<View className={"h-20 w-20 bg-[#50E3C2]"} />
				<View className={"h-20 w-20 bg-[#50E3C2]"} />
			</View>
			<View className={"flex-row items-center justify-between"}>
				<View className={"h-20 w-20 bg-[#4A90E2]"} />
				<View className={"h-20 w-20 bg-[#4A90E2]"} />
				<View className={"h-20 w-20 bg-[#4A90E2]"} />
			</View>
			<View className={"flex-row items-center justify-between"}>
				<View className={"h-20 w-20 bg-[#9013FE]"} />
				<View className={"h-20 w-20 bg-[#9013FE]"} />
				<View className={"h-20 w-20 bg-[#9013FE]"} />
			</View>
		</View>
	);
}
