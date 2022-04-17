import java.util.Scanner;

public class ERE03 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int soma = 0, pessoas = 0;

		for (int i = s.nextInt(); i >= 0; i = s.nextInt()) {
			soma += i;
			pessoas++;
		}

		if (pessoas == 0) {
			System.out.println("impossivel calcular");
		} else {
			System.out.printf("%.2f\n", ((double) soma / pessoas));
		}

		s.close();
	}
}
