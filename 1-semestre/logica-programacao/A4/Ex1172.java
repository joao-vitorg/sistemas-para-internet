import java.util.Scanner;

public class Ex1172 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int[] array = new int[10];

		for (int i = 0; i < 10; i++) {
			int aux = s.nextInt();

			array[i] = Math.max(aux, 1);
		}

		for (int i = 0; i < 10; i++) {
			System.out.printf("X[%d] = %d\n", i, array[i]);
		}

		s.close();
	}
}
