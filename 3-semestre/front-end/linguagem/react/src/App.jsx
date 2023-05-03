import { createHashRouter, createRoutesFromElements, Route } from "react-router-dom";
import "./App.css";

export default createHashRouter(
	createRoutesFromElements(
		<Route>
			<Route path={"/"} exact lazy={() => import("./Root.jsx")} />

			<Route path={"/introducao"}>
				<Route path={"ex1"} lazy={() => import("./exercicios/introducao/pages/Ex1.jsx")} />
				<Route path={"ex2"} lazy={() => import("./exercicios/introducao/pages/Ex2.jsx")} />
				<Route path={"ex3"} lazy={() => import("./exercicios/introducao/pages/Ex3.jsx")} />
				<Route path={"ex4"} lazy={() => import("./exercicios/introducao/pages/Ex4.jsx")} />
			</Route>

			<Route path={"use-state"}>
				<Route path={"ex1"} lazy={() => import("./exercicios/use-state/pages/Ex1.jsx")} />
				<Route path={"ex2"} lazy={() => import("./exercicios/use-state/pages/Ex2.jsx")} />
				<Route path={"ex3"} lazy={() => import("./exercicios/use-state/pages/Ex3.jsx")} />
				<Route path={"ex4"} lazy={() => import("./exercicios/use-state/pages/Ex4.jsx")} />
				<Route path={"ex5"} lazy={() => import("./exercicios/use-state/pages/Ex5.jsx")} />
			</Route>
		</Route>
	)
);
