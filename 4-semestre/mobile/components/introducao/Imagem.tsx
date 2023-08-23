import { Image, ImageSourcePropType } from "react-native";

export default function ({ imagem }: { imagem: ImageSourcePropType }) {
	return <Image className="w-full" source={imagem} />;
}
