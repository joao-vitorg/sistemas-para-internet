import { Image, Text, View } from "react-native";
import { useContext } from "react";
import { UserContext } from "./context/Auth";
import { Avatars } from "./@types/User";

export default function () {
	const user = useContext(UserContext);

	return (
		<View className={"flex-1 items-center justify-center space-y-6"}>
			<Text className={"text-xl font-bold"}>{user.email}</Text>
			<Image className={"h-36 w-36"} source={Avatars[user.avatar]} />
		</View>
	);
}
