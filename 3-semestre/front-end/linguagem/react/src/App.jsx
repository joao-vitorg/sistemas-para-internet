import { createHashRouter, createRoutesFromElements, Route } from "react-router-dom";
import "./App.css";

export default createHashRouter(
	createRoutesFromElements(
		<Route>
			<Route path={"/introducao/ex1/q1"} lazy={() => import("./introducao/exercicios/Ex1q1.jsx")} />
			<Route path={"/introducao/ex1/q2"} lazy={() => import("./introducao/exercicios/Ex1q2.jsx")} />
			<Route path={"/introducao/ex2"} lazy={() => import("./introducao/exercicios/Ex2.jsx")} />
			<Route path={"/introducao/ex3"} lazy={() => import("./introducao/exercicios/Ex3.jsx")} />
			<Route path={"/"} exact lazy={() => import("./Root.jsx")} />
		</Route>
	)
);
