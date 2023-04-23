import { Link } from "react-router-dom";

export function Component() {
	return (
		<>
			<ul>
				<ul>
					<li>
						<Link to={"/introducao/ex1/q1"}>Ex1q1</Link>
					</li>
					<li>
						<Link to={"/introducao/ex1/q2"}>Ex1q2</Link>
					</li>
				</ul>

				<li>
					<Link to={"/introducao/ex2"}>Ex2</Link>
				</li>

				<li>
					<Link to={"/introducao/ex3"}>Ex3</Link>
				</li>
			</ul>
		</>
	);
}
