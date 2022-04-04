import java.util.Scanner;

public class EC02 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double numero;

		numero = s.nextDouble();

		System.out.println(((numero >= 0 && numero <= 200) || numero == 1000) ? "Valido" : "Invalido");

		s.close();
	}
}
