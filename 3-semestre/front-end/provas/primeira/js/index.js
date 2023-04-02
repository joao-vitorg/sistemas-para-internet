const fetchJson = async (x) => await fetch(x).then((value) => value.json());
const element = (x) => document.getElementById(x);

const render = ({ marca, modelo, valor, imagem }) => {
	element("marca").innerText = marca;
	element("modelo").innerText = modelo;
	element("valor").innerText = valor;
	element("imagem").src = "img/" + imagem;
};

const pegarInformacoes = async () => {
	const produtos = [await fetchJson("db/geladeiras.json"), await fetchJson("db/celulares.json")];
	let posicao = 1;

	setInterval(() => {
		const tipo = element("tipo").selectedIndex;
		render(produtos[tipo][posicao]);
		posicao = ++posicao % 3;
	}, 1000);
};

pegarInformacoes().catch((e) => {
	console.log(e);
});
