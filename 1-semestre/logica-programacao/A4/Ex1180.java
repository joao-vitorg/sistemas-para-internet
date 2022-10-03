import java.util.Scanner;

public class Ex1180 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n, minPosi = 0, min = 1001;

		n = s.nextInt();
		int[] vetor = new int[n];

		for (int i = 0; i < n; i++) {
			vetor[i] = s.nextInt();
		}

		for (int i = 0; i < n; i++) {
			if (vetor[i] < min) {
				min = vetor[i];
				minPosi = i;
			}
		}

		System.out.println("Menor valor: " + min);
		System.out.println("Posicao: " + minPosi);

		s.close();
	}
}
