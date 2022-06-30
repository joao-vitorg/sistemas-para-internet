import java.util.Scanner;

public class Ex1046 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int inicio, fim, tempo;

		inicio = s.nextInt();
		fim = s.nextInt();

		tempo = (inicio >= fim) ? (24 - inicio + fim) : (fim - inicio);

		System.out.printf("O JOGO DUROU %d HORA(S)\n", tempo);

		s.close();
	}
}
