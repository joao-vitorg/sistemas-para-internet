import java.util.Scanner;

public class Ex1038 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int codigo, quantidade;
		double[] tabela = { 4, 4.5, 5, 2, 1.5 };

		codigo = s.nextInt();
		quantidade = s.nextInt();

		System.out.printf("Total: R$ %.2f\n", (tabela[codigo - 1] * quantidade));

		s.close();
	}
}