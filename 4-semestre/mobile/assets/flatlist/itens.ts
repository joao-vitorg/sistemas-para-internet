import { ImageSourcePropType } from "react-native";

export interface Item {
	image: ImageSourcePropType;
	name: string;
	quantity: number;
}

export const itens: Item[] = [
	{
		image: require("./01-tablelamps.png"),
		name: "Abajur",
		quantity: 0,
	},
	{
		image: require("./02-ceilinglamps.png"),
		name: "Lâmpada",
		quantity: 0,
	},
	{
		image: require("./03-sconces.png"),
		name: "Arante",
		quantity: 0,
	},
	{
		image: require("./04-floorlamps.png"),
		name: "Luminaria de chão",
		quantity: 0,
	},
	{
		image: require("./05-lightdecor.png"),
		name: "Luminaria decoração",
		quantity: 0,
	},
	{
		image: require("./06-garlands.png"),
		name: "Luminaria jardim",
		quantity: 0,
	},
];
