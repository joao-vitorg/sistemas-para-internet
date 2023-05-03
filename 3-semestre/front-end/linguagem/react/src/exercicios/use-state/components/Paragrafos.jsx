import { useState } from "react";

export default function Paragrafos() {
	const [texto, setTexto] = useState("");
	const [paragrafos, setParagrafos] = useState(["Parágrafo 1 (interface)", "Parágrafo 2 (interface)"]);

	return (
		<div>
			<form>
				<input type="text" value={texto} onChange={({ target }) => setTexto(target.value)} />
				<button
					onClick={() => {
						setParagrafos([...paragrafos, texto]);
						setTexto("");
					}}
				>
					Adicionar parágrafo
				</button>
			</form>

			{paragrafos.map((value, index) => (
				<p key={index}>{value}</p>
			))}
		</div>
	);
}
