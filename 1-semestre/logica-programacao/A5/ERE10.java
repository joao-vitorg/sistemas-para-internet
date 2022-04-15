import java.util.Scanner;

public class ERE10 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double nota;

		nota = s.nextDouble();

		while (!((nota >= 0 && nota <= 10) || (nota >= 100 && nota <= 200))) {
			System.out.println("nota invalida");
			nota = s.nextDouble();
		}

		System.out.printf("%.2f\n", nota);

		s.close();
	}
}
