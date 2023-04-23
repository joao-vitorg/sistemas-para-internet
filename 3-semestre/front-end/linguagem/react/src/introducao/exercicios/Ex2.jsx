import Avaliacao from "../components/Avaliacao.jsx";
import props from "./props.js";

export function Component() {
	return (
		<div className={"secao-avaliacao"}>
			<Avaliacao {...props[0]} />
			<Avaliacao {...props[1]} />
			<Avaliacao {...props[2]} />
		</div>
	);
}
