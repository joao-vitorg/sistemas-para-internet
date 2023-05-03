import "./Avaliacao.css";

export default function Avaliacao({ foto, nome, avaliacao1, avaliacao2 }) {
	return (
		<div className={"avaliacao"}>
			<img src={`./img/${foto}`} alt="Foto" />
			<div>
				<p>{nome}</p>
				<p>"{avaliacao1}"</p>
				<p>"{avaliacao2}"</p>
			</div>
		</div>
	);
}
