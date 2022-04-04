import java.util.Scanner;

public class EC01 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numero;

		numero = s.nextInt();

		System.out.println((numero >= 0 && numero <= 200) ? "Valido" : "Invalido");

		s.close();
	}
}
