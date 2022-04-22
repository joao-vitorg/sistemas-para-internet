import java.util.Scanner;

public class ERP04 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double soma = 0;

		for (int i = 1, n = s.nextInt(); i <= n; i++) {
			soma += 1.0 / i;
		}

		System.out.printf("%.4f", soma);

		s.close();
	}
}
