import Avaliacao from "../components/Avaliacao.jsx";
import "./style.css";

export function Component() {
	const avaliacoes = [
		{
			nome: "Steve Jobs",
			foto: "steve-jobs.jpg",
			avaliacao1: "Eu recomendo a Leticia, pois o atendimento dela fez toda diferença",
			avaliacao2:
				"A escolha de um imóvel, no nosso caso uma casa, não é uma tarefa fácil. A escolha de um profissional qualificado poupou o nosso tempo e nos ajudou a encontrar o que realmente queríamos",
		},
		{
			nome: "Trump",
			foto: "trump.jpg",
			avaliacao1: "Eu recomendo a Leticia, pois o atendimento dela fez toda diferença",
			avaliacao2:
				"A escolha de um imóvel, no nosso caso uma casa, não é uma tarefa fácil. A escolha de um profissional qualificado poupou o nosso tempo e nos ajudou a encontrar o que realmente queríamos",
		},
		{
			nome: "Rainha Elizabeth",
			foto: "rainha-elizabeth.jpg",
			avaliacao1: "Eu recomendo a Leticia, pois o atendimento dela fez toda diferença",
			avaliacao2:
				"A escolha de um imóvel, no nosso caso uma casa, não é uma tarefa fácil. A escolha de um profissional qualificado poupou o nosso tempo e nos ajudou a encontrar o que realmente queríamos",
		},
		{
			nome: "Michael Jackson",
			foto: "michael-jackson.jpg",
			avaliacao1: "Eu recomendo a Leticia, pois o atendimento dela fez toda diferença",
			avaliacao2:
				"A escolha de um imóvel, no nosso caso uma casa, não é uma tarefa fácil. A escolha de um profissional qualificado poupou o nosso tempo e nos ajudou a encontrar o que realmente queríamos",
		},
		{
			nome: "Ibere Thenorio",
			foto: "ibere-thenorio.png",
			avaliacao1: "Eu recomendo a Leticia, pois o atendimento dela fez toda diferença",
			avaliacao2:
				"A escolha de um imóvel, no nosso caso uma casa, não é uma tarefa fácil. A escolha de um profissional qualificado poupou o nosso tempo e nos ajudou a encontrar o que realmente queríamos",
		},
	];

	const getRamdom = () => {
		let arr = [];
		for (let i = 0; i < 3; i++) {
			arr.push(avaliacoes.splice(Math.floor(Math.random() * (5 - i)), 1)[0]);
		}
		return arr;
	};

	return (
		<div className={"secao-avaliacao"}>
			{getRamdom().map((data, index) => (
				<Avaliacao {...data} key={index} />
			))}
		</div>
	);
}
