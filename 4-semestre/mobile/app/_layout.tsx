import { Stack } from "expo-router";

import "../global.css";

export default function() {
	return (
		<Stack>
			<Stack.Screen name={"introducao"} options={{ headerShown: false }} />
		</Stack>
	);
}
