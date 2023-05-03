import { useState } from "react";

export default function FormularioNome() {
	const [nome, setNome] = useState("");

	return (
		<div>
			<form>
				<label htmlFor="nome">Nome: </label>
				<input type="text" id="nome" onChange={({ target }) => setNome(target.value)} />
			</form>

			<p>{nome.toUpperCase()}</p>
		</div>
	);
}
