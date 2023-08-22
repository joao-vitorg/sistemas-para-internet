import { View } from "react-native";

export default function() {
	return (
		<View className={"flex-1 flex-row items-center justify-between"}>
			<View className={"bg-[#50E3C2] w-20 h-20"} />
			<View className={"bg-[#4A90E2] w-20 h-20"} />
			<View className={"bg-[#9013FE] w-20 h-20"} />
		</View>
	);
}
