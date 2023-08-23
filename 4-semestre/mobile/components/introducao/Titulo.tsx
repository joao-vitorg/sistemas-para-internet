import { Text } from "react-native";

export default function ({ titulo }: { titulo: string }) {
	return <Text className={"text-2xl font-bold text-center"}>{titulo}</Text>;
}
