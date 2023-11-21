import { useContext, useState } from "react";
import { Alert, Image, Pressable, Text, TextInput, View } from "react-native";
import { createUserWithEmailAndPassword, updateProfile } from "@firebase/auth";
import { auth } from "../../services/firebase";
import { Avatars } from "./@types/User";
import { router } from "expo-router";
import { UserContext } from "./context/Auth";

export default function () {
	const [email, setEmail] = useState("");
	const [password, setPassword] = useState("");
	const [avatar, setAvatar] = useState(0);
	const user = useContext(UserContext);

	const signup = async () => {
		if (email.length === 0) return Alert.alert("Erro", "Digite um email");
		if (password.length === 0) return Alert.alert("Erro", "Digite uma senha");
		if (avatar === 0) return Alert.alert("Erro", "Selecione um avatar");

		try {
			const login = (await createUserWithEmailAndPassword(auth, email, password)).user;
			await updateProfile(login, { photoURL: avatar.toString() });
			setEmail("");
			setPassword("");
			setAvatar(0);
			user.email = login.email!;
			user.avatar = +login.photoURL!;
			router.replace("/firebase/profile");
		} catch (error) {
			// @ts-ignore
			return Alert.alert("Erro", error.message);
		}
	};

	return (
		<View className={"flex-1 items-center justify-center space-y-5"}>
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
			<View className={"mb-3 flex-row space-x-2"}>
				<Pressable
					className={`rounded p-1 shadow ${avatar === 1 ? "bg-green-500" : "bg-gray-500"}`}
					onPress={() => setAvatar(1)}
				>
					<Image className={"h-24 w-24"} source={Avatars[1]} />
				</Pressable>
				<Pressable
					className={`rounded p-1 shadow ${avatar === 2 ? "bg-green-500" : "bg-gray-500"}`}
					onPress={() => setAvatar(2)}
				>
					<Image className={"h-24 w-24"} source={Avatars[2]} />
				</Pressable>
			</View>
			<Pressable className={"rounded bg-blue-500 p-2 shadow"} onPress={signup}>
				<Text className={"text-base font-bold text-white"}>Sign Up</Text>
			</Pressable>
		</View>
	);
}
