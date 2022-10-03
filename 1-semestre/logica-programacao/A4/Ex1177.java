import java.util.Scanner;

public class Ex1177 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int[] vetor = new int[1000];

		for (int i = 0, j = 0; i < 1000; i++, j++) {
			if (j == n) {
				j = 0;
			}

			vetor[i] = j;
		}

		for (int i = 0; i < 1000; i++) {
			System.out.printf("N[%d] = %d\n", i, vetor[i]);
		}

		s.close();
	}
}
