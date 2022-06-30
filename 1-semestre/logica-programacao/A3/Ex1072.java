import java.util.Scanner;

public class Ex1072 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int in = 0, out = 0;

		for (int n, i = s.nextInt(); i > 0; i--) {
			n = s.nextInt();

			if (n >= 10 && n <= 20) {
				in++;
			} else {
				out++;
			}
		}

		System.out.printf("%d in\n", in);
		System.out.printf("%d out\n", out);

		s.close();
	}
}
