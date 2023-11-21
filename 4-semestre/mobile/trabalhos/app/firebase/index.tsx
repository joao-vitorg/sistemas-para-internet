import { Alert, Pressable, Text, TextInput, View } from "react-native";
import { Link, router } from "expo-router";
import { signInWithEmailAndPassword } from "@firebase/auth";
import { auth } from "../../services/firebase";
import { useContext, useState } from "react";
import { UserContext } from "./context/Auth";

export default function () {
	const [email, setEmail] = useState("");
	const [password, setPassword] = useState("");
	const user = useContext(UserContext);

	const signing = async () => {
		if (email.length === 0) return Alert.alert("Erro", "Digite um email");
		if (password.length === 0) return Alert.alert("Erro", "Digite uma senha");

		try {
			const login = (await signInWithEmailAndPassword(auth, email, password)).user;
			user.email = login.email!;
			user.avatar = +login.photoURL!;
			setEmail("");
			setPassword("");
			router.replace("/firebase/profile");
		} catch (error) {
			// @ts-ignore
			return Alert.alert("Erro", error.message);
		}
	};

	return (
		<View className={"flex-1 items-center justify-center space-y-6"}>
			<View className={"w-60 space-y-2"}>
				<TextInput
					className={"rounded border-2 bg-white p-0.5 pl-2 shadow"}
					placeholder={"Email"}
					value={email}
					onChangeText={setEmail}
					keyboardType={"email-address"}
				/>
				<TextInput
					className={"rounded border-2 bg-white p-0.5 pl-2 shadow"}
					placeholder={"Password"}
					value={password}
					onChangeText={setPassword}
					secureTextEntry={true}
				/>
			</View>
			<Pressable className={"w-60 items-center rounded bg-blue-500 p-2 shadow"} onPress={signing}>
				<Text className={"text-base font-bold text-white"}>Sign In</Text>
			</Pressable>
			<Text className={"text-base"}>
				I don't have an account
				<Link className={"font-bold text-blue-500"} href={"/firebase/signup"}>
					{" Sign Up"}
				</Link>
			</Text>
		</View>
	);
}
