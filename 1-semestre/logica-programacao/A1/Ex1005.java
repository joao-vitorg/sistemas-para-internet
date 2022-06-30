import java.util.Scanner;

public class Ex1005 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double primeiroNumero, segundoNumero;

		primeiroNumero = s.nextDouble();
		segundoNumero = s.nextDouble();

		System.out.printf("MEDIA = %.5f\n", (primeiroNumero * 3.5 + segundoNumero * 7.5) / 11);

		s.close();
	}
}
