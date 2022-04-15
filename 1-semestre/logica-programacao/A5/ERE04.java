import java.util.Scanner;

public class ERE04 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] candidatos = { 0, 0, 0, 0, 0 };

		for (int i = s.nextInt(); i != 0; i--) {
			candidatos[s.nextInt() - 1]++;
		}

		System.out.printf("Candidato 1 : %d voto(s)\n", candidatos[0]);
		System.out.printf("Candidato 2 : %d voto(s)\n", candidatos[1]);
		System.out.printf("Candidato 3 : %d voto(s)\n", candidatos[2]);
		System.out.printf("Nulos : %d voto(s)\n", candidatos[3]);
		System.out.printf("Brancos : %d voto(s)\n", candidatos[4]);

		s.close();
	}
}
