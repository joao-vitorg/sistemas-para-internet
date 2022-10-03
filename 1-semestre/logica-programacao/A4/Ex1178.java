import java.util.Scanner;

public class Ex1178 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		double x = s.nextDouble();
		double[] vetor = new double[100];

		for (int i = 0; i < 100; i++, x /= 2) {
			vetor[i] = x;
		}

		for (int i = 0; i < 100; i++) {
			System.out.printf("N[%d] = %.4f\n", i, vetor[i]);
		}

		s.close();
	}
}
