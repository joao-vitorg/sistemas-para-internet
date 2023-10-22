import { Tabs } from "expo-router";

import "../global.css";
import { Ionicons } from "@expo/vector-icons";

export default function () {
	return (
		<Tabs screenOptions={{ headerShown: false }}>
			<Tabs.Screen name="itens" options={{ tabBarIcon: () => <Ionicons name="basket" size={24} color="black" /> }} />
			<Tabs.Screen
				name="index"
				options={{ title: "Lançes", tabBarIcon: () => <Ionicons name="hammer-sharp" size={24} color="black" /> }}
			/>
			<Tabs.Screen
				name="participantes"
				options={{
					title: "Participantes",
					tabBarIcon: () => <Ionicons name="person" size={24} color="black" />,
				}}
			/>
		</Tabs>
	);
}
