import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int primeiroNumero, segundoNumero, terceiroNumero, menorNumero;

		primeiroNumero = s.nextInt();
		segundoNumero = s.nextInt();
		terceiroNumero = s.nextInt();

		menorNumero = Math.min(Math.min(primeiroNumero, segundoNumero), terceiroNumero);

		System.out.println("O menor número é " + menorNumero);

		s.close();
	}
}
