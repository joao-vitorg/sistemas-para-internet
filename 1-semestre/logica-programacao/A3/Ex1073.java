import java.util.Scanner;

public class Ex1073 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n;

		n = s.nextInt();
		n -= n & 1;

		for (int i = 2; i <= n; i += 2) {
			System.out.printf("%d^2 = %d\n", i, i * i);
		}

		s.close();
	}
}
