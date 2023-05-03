import Avaliacao from "../components/Avaliacao.jsx";
import "./style.css";

export function Component() {
	return (
		<div className={"secao-avaliacao"}>
			<Avaliacao
				nome={"Steve Jobs"}
				foto={"steve-jobs.jpg"}
				avaliacao1={"Eu recomendo a Leticia, pois o atendimento dela fez toda diferença"}
				avaliacao2={
					"A escolha de um imóvel, no nosso caso uma casa, não é uma tarefa fácil. A escolha de um profissional qualificado poupou o nosso tempo e nos ajudou a encontrar o que realmente queríamos"
				}
			/>
			<Avaliacao
				nome={"Trump"}
				foto={"trump.jpg"}
				avaliacao1={"Eu recomendo a Leticia, pois o atendimento dela fez toda diferença"}
				avaliacao2={
					"A escolha de um imóvel, no nosso caso uma casa, não é uma tarefa fácil. A escolha de um profissional qualificado poupou o nosso tempo e nos ajudou a encontrar o que realmente queríamos"
				}
			/>
			<Avaliacao
				nome={"Rainha Elizabeth"}
				foto={"rainha-elizabeth.jpg"}
				avaliacao1={"Eu recomendo a Leticia, pois o atendimento dela fez toda diferença"}
				avaliacao2={
					"A escolha de um imóvel, no nosso caso uma casa, não é uma tarefa fácil. A escolha de um profissional qualificado poupou o nosso tempo e nos ajudou a encontrar o que realmente queríamos"
				}
			/>
		</div>
	);
}
