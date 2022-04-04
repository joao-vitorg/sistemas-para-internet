import java.util.Scanner;

public class Ex1002 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double raioCirculo;

		raioCirculo = s.nextDouble();

		System.out.printf("A=%.4f\n", 3.14159 * Math.pow(raioCirculo, 2));

		s.close();
	}
}
