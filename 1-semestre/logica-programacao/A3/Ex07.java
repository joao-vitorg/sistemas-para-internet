import java.util.Scanner;

public class Ex07 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double saldoMedio;

		saldoMedio = s.nextDouble();

		if (saldoMedio > 600)
			System.out.printf("Valor de crédito é %.2f\n", saldoMedio * 0.4);
		else if (saldoMedio >= 400)
			System.out.printf("Valor de crédito é %.2f\n", saldoMedio * 0.3);
		else if (saldoMedio >= 200)
			System.out.printf("Valor de crédito é %.2f\n", saldoMedio * 0.2);
		else
			System.out.println("Sem direito a crédito");

		s.close();
	}
}