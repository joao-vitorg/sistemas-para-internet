import { Link } from "expo-router";
import { View } from "react-native";

export default function() {
	return (
		<View className={"p-3 gap-3"}>
			<Link href={"/introducao/ex01"} className={"text-xl font-bold"}>Exercício 2.1</Link>
			<Link href={"/introducao/ex02"} className={"text-xl font-bold"}>Exercício 2.2</Link>
			<Link href={"/introducao/ex03"} className={"text-xl font-bold"}>Exercício 2.3</Link>
			<Link href={"/introducao/ex04"} className={"text-xl font-bold"}>Exercício 2.4</Link>
			<Link href={"/introducao/ex05"} className={"text-xl font-bold"}>Exercício 2.5</Link>
			<Link href={"/introducao/ex06"} className={"text-xl font-bold"}>Exercício 3</Link>
			<Link href={"/introducao/ex07"} className={"text-xl font-bold"}>Exercício card</Link>
		</View>
	);
}
