import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int primeiroNumero, segundoNumero;

		primeiroNumero = s.nextInt();
		segundoNumero = s.nextInt();

		System.out.println("o maior número é " + Math.max(primeiroNumero, segundoNumero));

		s.close();
	}
}
