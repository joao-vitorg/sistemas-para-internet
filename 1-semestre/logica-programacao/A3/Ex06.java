import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int ano, preco;

		ano = s.nextInt();
		preco = s.nextInt();

		System.out.printf("Taxa de transferência é %.2f\n", (preco * ((ano >= 2000) ? 0.015 : 0.01)));

		s.close();
	}
}