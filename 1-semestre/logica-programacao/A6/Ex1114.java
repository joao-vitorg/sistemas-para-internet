import java.util.Scanner;

public class Ex1114 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		for (int senha = s.nextInt(); senha != 2002; senha = s.nextInt()) {
			System.out.println("Senha Invalida");
		}

		System.out.println("Acesso Permitido");

		s.close();
	}
}
