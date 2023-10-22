import { Text } from "react-native";

export default function ({ titulo }: { titulo: string }) {
	return <Text className={"text-center text-2xl font-bold"}>{titulo}</Text>;
}
