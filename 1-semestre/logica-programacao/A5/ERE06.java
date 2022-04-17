import java.util.Scanner;

public class ERE06 {
	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int ano;

		ano = s.nextInt();

		for (; (ano < 1900 || ano > 2022); ano = s.nextInt()) {
			System.out.println("Ano invalido");
		}

		System.out.println(ano);
	}
}
