import { Image, View } from "react-native";

export default function () {
	return (
		<View className={"flex-1 items-center justify-center gap-3"}>
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
