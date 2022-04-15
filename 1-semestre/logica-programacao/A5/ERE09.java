import java.util.Scanner;

public class ERE09 {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int inicio, fim;

		inicio = s.nextInt() + 1;
		fim = s.nextInt();

		for (; inicio < fim; inicio++) {
			System.out.println(inicio);
		}
	}
}
