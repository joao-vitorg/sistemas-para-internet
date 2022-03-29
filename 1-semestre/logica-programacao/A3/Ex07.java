import java.util.Scanner;

public class Ex07 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double saldoMedio, credito;
		
		saldoMedio = s.nextDouble();

		credito = saldoMedio * ((saldoMedio>600) ? 0.4 :
								(saldoMedio>=400) ? 0.3 :
								(saldoMedio>=200) ? 0.2 : 0);

		if (credito!=0) {
			System.out.printf("Valor de crédito é %.2f\n", credito);
		} else {
			System.out.println("Sem direito a crédito");
		}

		s.close();
	}
}