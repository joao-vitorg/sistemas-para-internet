import Card from "../../components/introducao/Card";
import { Stack } from "expo-router";

export default function () {
	return (
		<>
			<Stack.Screen options={{ title: "Exercício Card" }} />
			<Card titulo={"Título"} texto={"Sub título"} imagem={require("../../assets/introducao/casa.jpg")} />
		</>
	);
}
