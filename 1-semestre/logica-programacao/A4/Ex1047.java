import java.util.Scanner;

public class Ex1047 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int horaInicio, minutoInicio, horaFim, minutoFim, inicio, fim, tempo;

		horaInicio = s.nextInt();
		minutoInicio = s.nextInt();
		horaFim = s.nextInt();
		minutoFim = s.nextInt();

		inicio = horaInicio * 60 + minutoInicio;
		fim = horaFim * 60 + minutoFim;

		tempo = (inicio >= fim) ? (1440 - inicio + fim) : (fim - inicio);

		System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", tempo / 60, tempo % 60);

		s.close();
	}
}
