import java.util.Scanner;

public class Ex1004 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int primeiroNumero, segundoNumero;

		primeiroNumero = s.nextInt();
		segundoNumero = s.nextInt();

		System.out.println("PROD = " + primeiroNumero * segundoNumero);

		s.close();
	}
}
