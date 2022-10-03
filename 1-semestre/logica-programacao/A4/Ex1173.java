import java.util.Scanner;

public class Ex1173 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n;

		n = s.nextInt();

		int[] array = new int[10];
		array[0] = n;

		for (int i = 1; i < 10; i++) {
			array[i] = array[i - 1] * 2;
		}

		for (int i = 0; i < 10; i++) {
			System.out.printf("N[%d] = %d\n", i, array[i]);
		}

		s.close();
	}
}
