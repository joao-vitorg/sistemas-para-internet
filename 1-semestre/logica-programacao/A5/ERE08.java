import java.util.Scanner;

public class ERE08 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numero;

		numero = s.nextInt();

		for (int i = 1; i <= 10; i++) {
			System.out.printf("%d x %d = %d\n", numero, i, numero * i);
		}

		s.close();
	}
}
