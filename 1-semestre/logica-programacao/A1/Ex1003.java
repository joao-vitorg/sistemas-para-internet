import java.util.Scanner;

public class Ex1003 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int primeiroNumero, segundoNumero;

		primeiroNumero = s.nextInt();
		segundoNumero = s.nextInt();

		System.out.println("SOMA = " + primeiroNumero + segundoNumero);

		s.close();
	}
}
