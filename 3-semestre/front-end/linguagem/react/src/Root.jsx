import { Link } from "react-router-dom";

const generateItens = (num, base) => (
	<div>
		<h2 style={{ textTransform: "capitalize" }}>{base.replaceAll("-", " ")}</h2>

		<ul>
			{[...Array(num).keys()].map((i) => (
				<li key={i}>
					<Link to={`/${base}/ex${i + 1}`}>Exercício {i + 1}</Link>
				</li>
			))}
		</ul>
	</div>
);

export function Component() {
	return (
		<div>
			{generateItens(4, "introducao")}

			{generateItens(5, "use-state")}
		</div>
	);
}
