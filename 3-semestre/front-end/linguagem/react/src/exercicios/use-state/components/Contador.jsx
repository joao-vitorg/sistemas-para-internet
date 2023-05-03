import { useState } from "react";

export default function Contador({ limiteMin, limiteMax }) {
	const [contador, setContador] = useState(limiteMin);

	return (
		<div>
			<p>
				<span style={{ color: "red" }}>Intervalo (limite) do contador:</span> [{limiteMin}, {limiteMax}]
			</p>
			<p>
				<span style={{ fontWeight: "bold" }}>Valor atual do contador:</span> {contador}
			</p>
			<div>
				<button type={"button"} onClick={() => (contador < limiteMax ? setContador(contador + 1) : null)}>
					+
				</button>
				<button type={"button"} onClick={() => (contador > limiteMin ? setContador(contador - 1) : null)}>
					-
				</button>
			</div>
			<hr />
		</div>
	);
}
