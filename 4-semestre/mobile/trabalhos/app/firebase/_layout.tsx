import { Stack } from "expo-router";
import { createContext } from "react";
import { User } from "./@types/User";

const UserContext = createContext({} as User);

export default function () {
	return (
		<UserContext.Provider value={{ email: "", avatar: 0 }}>
			<Stack screenOptions={{ title: "Firebase" }}>
				<Stack.Screen name={"signing"} options={{ title: "Sign In" }} />
				<Stack.Screen name={"signup"} options={{ title: "Sign Up" }} />
				<Stack.Screen name={"profile"} options={{ title: "Profile" }} />
			</Stack>
		</UserContext.Provider>
	);
}
