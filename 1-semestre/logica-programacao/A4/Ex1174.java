import java.util.Scanner;

public class Ex1174 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		double[] array = new double[100];

		for (int i = 0; i < 100; i++) {
			array[i] = s.nextDouble();
		}

		for (int i = 0; i < 100; i++) {
			double aux = array[i];

			if (aux <= 10) {
				System.out.printf("A[%d] = %.1f\n", i, aux);
			}
		}

		s.close();
	}
}
