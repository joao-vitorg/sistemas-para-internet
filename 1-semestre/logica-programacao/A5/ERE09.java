import java.util.Scanner;

public class ERE09 {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int inicio, fim;

		inicio = s.nextInt();
		fim = s.nextInt();

		for (int i = inicio + 1; i < fim; i++) {
			System.out.println(i);
		}
	}
}
