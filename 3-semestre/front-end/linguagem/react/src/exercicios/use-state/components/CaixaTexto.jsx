import { useState } from "react";

export default function CaixaTexto({ tamanhoMax }) {
	const [caracteres, setCaracteres] = useState(0);

	return (
		<div>
			<form>
				<p>Mensagem:</p>
				<textarea
					id="texto"
					cols="100"
					rows="10"
					maxLength={tamanhoMax}
					onChange={({ target: { value } }) => setCaracteres(value.length)}
				></textarea>
			</form>

			<p>Restante: {tamanhoMax - caracteres} caracteres</p>
		</div>
	);
}
