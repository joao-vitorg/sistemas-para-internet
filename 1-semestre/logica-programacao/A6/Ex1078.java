import java.util.Scanner;

public class Ex1078 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		for (int i = 1, n = s.nextInt(); i <= 10; i++) {
			System.out.printf("%d x %d = %d\n", i, n, i * n);
		}

		s.close();
	}
}
