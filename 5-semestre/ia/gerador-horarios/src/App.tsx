// import DISCIPLINAS from "./services/disciplinas.json";
// import PROFESSORES from "./services/professores.json";

import { useEffect, useState } from "react";

export default function App() {
	const [periodos, setPeriodos] = useState(5);
	const [horarios, setHorarios] = useState<Number[][][][]>([]);

	useEffect(() => {
		gerarHorario();
	}, []);

	function gerarDisciplinasAleatorias(periodo: number) {
		const disciplinas = Array(periodos)
			.fill(periodos * periodo)
			.map((x, y) => x + y); // gera todas as disciplinas do periodo
		return [...disciplinas, ...disciplinas].sort(() => Math.random() - 0.5); // duplica a lista e randomiza
	}

	function gerarHorario() {
		const tmpHorarios: Number[][][][] = [];
		for (let periodo = 0; periodo < periodos; periodo++) {
			const dias = [];
			const disciplinas = gerarDisciplinasAleatorias(periodo);
			for (let dia = 0; dia < 5; dia++) {
				const horario = [];
				for (let hora = 0; hora < 2; hora++) {
					let disciplina = disciplinas.shift();
					let professor = disciplina % 12;
					horario.push([disciplina, professor]);
				}
				dias.push(horario);
			}
			tmpHorarios.push(dias);
		}
		setHorarios(tmpHorarios);
	}

	function verificarDivergencias() {
		let divergencias = 0;
		for (let horario = 0; horario < 2; horario++) {
			for (let diaSemana = 0; diaSemana < 5; diaSemana++) {
				const divergencia: Array<Number> = [];
				for (let periodo = 0; periodo < 5; periodo++) {
					const professor = horarios[periodo][diaSemana][horario][1];
					if (divergencia.includes(professor)) divergencias++;
					divergencia.push(professor);
					console.log(`${divergencia} - ${divergencias}`);
				}
			}
		}
		return divergencias;
	}

	return (
		<>
			<div>
				<h2>Horários</h2>
				<button onClick={() => console.log(verificarDivergencias())}>Botão</button>
				<div>
					{horarios.map((periodo, index) => (
						<div className="p-3">
							<h3>Periodo {index + 1}</h3>
							<div className="flex">
								{periodo.map((dia, index) => (
									<div className="w-full px-3">
										<h4>Dia {index + 1}</h4>
										<div>
											{dia.map((horario) => (
												<p className="py-3">
													{horario[0]} / {horario[1]}
												</p>
											))}
										</div>
									</div>
								))}
							</div>
						</div>
					))}
				</div>
			</div>
		</>
	);
}
