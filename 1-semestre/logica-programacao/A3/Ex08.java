import java.util.Scanner;

public class Ex08 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int quantidadeMaca;

		quantidadeMaca = s.nextInt();

		System.out.printf("Valor da compra é %.2f\n", (quantidadeMaca * ((quantidadeMaca >= 12) ? 0.25 : 0.3)));

		s.close();
	}
}