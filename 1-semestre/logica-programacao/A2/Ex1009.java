import java.util.Scanner;

public class Ex1009 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double salario, vendasTotal;

		s.nextLine();
		salario = s.nextDouble();
		vendasTotal = s.nextDouble();

		System.out.printf("TOTAL = R$ %.2f\n", (salario + (vendasTotal * 0.15)));

		s.close();
	}
}
