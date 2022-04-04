import java.util.Scanner;

public class Ex1001 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int primeiroNumero, SegundoNumero;

		primeiroNumero = s.nextInt();
		SegundoNumero = s.nextInt();

		System.out.println("X = " + primeiroNumero + SegundoNumero);

		s.close();
	}
}
