import { Stack } from "expo-router";

export default function () {
	return (
		<Stack screenOptions={{ title: "Introdução" }}>
			<Stack.Screen name={"ex01"} options={{ title: "Atividade 2.1" }} />
			<Stack.Screen name={"ex02"} options={{ title: "Atividade 2.2" }} />
			<Stack.Screen name={"ex03"} options={{ title: "Atividade 2.3" }} />
			<Stack.Screen name={"ex04"} options={{ title: "Atividade 2.4" }} />
			<Stack.Screen name={"ex05"} options={{ title: "Atividade 2.5" }} />
			<Stack.Screen name={"ex06"} options={{ title: "Atividade 6" }} />
			<Stack.Screen name={"ex07"} options={{ title: "Atividade Card" }} />
		</Stack>
	);
}
