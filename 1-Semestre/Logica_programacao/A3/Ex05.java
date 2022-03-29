import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double horaAula, pagamento;
		int nivel;
		
		nivel = s.nextInt();
		horaAula = s.nextDouble();
		
		pagamento = horaAula * ((nivel==1) ? 12 : 
								(nivel==2) ? 17 : 
								(nivel==3) ? 25 : 0);

		System.out.printf("O pagamento é de %.2f\n", pagamento);

		s.close();
	}
}