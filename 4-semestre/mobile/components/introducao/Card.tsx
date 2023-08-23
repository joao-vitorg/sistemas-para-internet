import { ImageSourcePropType, View } from "react-native";
import Titulo from "./Titulo";
import Paragrafo from "./Paragrafo";
import Imagem from "./Imagem";

interface props {
	titulo: string;
	texto: string;
	imagem: ImageSourcePropType;
}

export default function ({ titulo, texto, imagem }: props) {
	return (
		<View className={"p-2"}>
			<Titulo titulo={titulo} />
			<Paragrafo texto={texto} />
			<Imagem imagem={imagem} />
		</View>
	);
}
