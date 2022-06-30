import java.util.Scanner;

public class Ex1014 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double gasolinaGasta;
		int distancia;

		distancia = s.nextInt();
		gasolinaGasta = s.nextDouble();

		System.out.printf("%.3f km/l\n", distancia / gasolinaGasta);

		s.close();
	}
}
