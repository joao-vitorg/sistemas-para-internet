import java.util.Scanner;

public class Ex1071 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x, y, max, min, soma = 0;

		x = s.nextInt();
		y = s.nextInt();

		max = Math.max(x, y) - 1;
		min = Math.min(x, y) + 1;

		for (int i = min | 1; i <= max; i += 2) {
			soma += i;
		}

		System.out.println(soma);

		s.close();
	}
}
