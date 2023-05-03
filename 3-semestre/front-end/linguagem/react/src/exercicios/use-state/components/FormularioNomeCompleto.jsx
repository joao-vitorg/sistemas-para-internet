import { useState } from "react";

export default function FormularioNomeCompleto() {
	const [nome, setNome] = useState("");
	const [sobrenome, setSobrenome] = useState("");
	const [nomeCompleto, setNomeCompleto] = useState("");

	return (
		<div>
			<form>
				<label htmlFor="nome">Nome: </label>
				<input type="text" id="nome" onChange={({ target }) => setNome(target.value)} />
				<br />
				<label htmlFor="sobrenome">Sobrenome: </label>
				<input type="text" id="sobrenome" onChange={({ target }) => setSobrenome(target.value)} />
				<br />
				<button onClick={() => setNomeCompleto(`${nome} ${sobrenome}`)}>Exibir nome completo</button>
			</form>

			<p>{nomeCompleto}</p>
		</div>
	);
}
