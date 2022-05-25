import java.util.Arrays;
import java.util.Scanner;

public class Ex1171 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n;

		n = s.nextInt();

		int array[] = new int[2001];
		Arrays.fill(array, 0);

		for (int i = 0; i < n; i++) {
			array[s.nextInt()]++;
		}

		for (int i = 0; i <= 2000; i++) {
			int aux = array[i];

			if (aux != 0) {
				System.out.printf("%d aparece %d vez(es)\n", i, aux);
			}
		}

		s.close();
	}
}
