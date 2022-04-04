import java.util.Scanner;

public class Ex1006 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double primeiroNumero, segundoNumero, terceiroNumero;

		primeiroNumero = s.nextDouble();
		segundoNumero = s.nextDouble();
		terceiroNumero = s.nextDouble();

		System.out.printf("MEDIA = %.1f\n", (primeiroNumero * 2 + segundoNumero * 3 + terceiroNumero * 5) / 10);

		s.close();
	}
}
