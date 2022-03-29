import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int primeiroNumero, segundoNumero, maiorNumero;

		primeiroNumero = s.nextInt();
		segundoNumero = s.nextInt();

		maiorNumero = Math.max(primeiroNumero, segundoNumero);

		System.out.println("o maior número é " + maiorNumero);

		s.close();
	}
}
