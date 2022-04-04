import java.util.Scanner;

public class Ex1007 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int primeiroNumero, segundoNumero, terceiroNumero, quartoNumero;

		primeiroNumero = s.nextInt();
		segundoNumero = s.nextInt();
		terceiroNumero = s.nextInt();
		quartoNumero = s.nextInt();

		System.out.println("DIFERENCA = " + (primeiroNumero * segundoNumero - terceiroNumero * quartoNumero));

		s.close();
	}
}
