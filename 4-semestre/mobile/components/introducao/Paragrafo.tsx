import { Text } from "react-native";

export default function({ texto }: { texto: string }) {
	return (
		<Text className={"text-justify"}>{texto}</Text>
	);
}
