import java.util.Scanner;

public class ERE10 {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		double nota;

		nota = s.nextDouble();

		for (; !((nota >= 0 && nota <= 10) || (nota >= 100 && nota <= 200)); nota = s.nextDouble()) {
			System.out.println("nota invalida");
		}

		System.out.printf("%.2f\n", nota);
	}
}
