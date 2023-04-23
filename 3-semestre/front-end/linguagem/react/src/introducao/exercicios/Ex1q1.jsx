import Avaliacao from "../components/Avaliacao.jsx";

export function Component() {
	return (
		<Avaliacao
			nome={"Steve Jobs"}
			foto={"steve-jobs.jpg"}
			avaliacao1={"Eu recomendo a Leticia, pois o atendimento dela fez toda diferença"}
			avaliacao2={
				"A escolha de um imóvel, no nosso caso uma casa, não é uma tarefa fácil. A escolha de um profissional qualificado poupou o nosso tempo e nos ajudou a encontrar o que realmente queríamos"
			}
		/>
	);
}
