import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] tabela = { 12, 17, 25 };
		double horaAula;
		int nivel;

		nivel = s.nextInt();
		horaAula = s.nextDouble();

		System.out.printf("O pagamento é de %.2f\n", tabela[nivel - 1] * horaAula);

		s.close();
	}
}