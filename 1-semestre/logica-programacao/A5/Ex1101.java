import java.util.Scanner;

public class Ex1101 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m, n, max, min, sum;

		while (true) {
			m = s.nextInt();
			n = s.nextInt();

			if (m > 0 && n > 0) {
				max = Math.max(m, n);
				min = Math.min(m, n);
				sum = 0;

				for (int i = min; i <= max; i++) {
					System.out.print(i + " ");
					sum += i;
				}

				System.out.println("Sum=" + sum);
			} else {
				break;
			}
		}

		s.close();
	}
}
