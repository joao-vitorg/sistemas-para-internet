import java.util.Scanner;

public class Ex1011 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double raioEsfera;

		raioEsfera = s.nextDouble();

		System.out.printf("VOLUME = %.3f\n", ((4 / 3.0) * 3.14159 * Math.pow(raioEsfera, 3)));

		s.close();
	}
}
