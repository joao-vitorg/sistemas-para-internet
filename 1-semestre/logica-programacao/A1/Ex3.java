import java.util.Scanner;

public class Ex3 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double baseRetangulo, alturaRetangulo, diagonal;

		baseRetangulo = s.nextDouble();
		alturaRetangulo = s.nextDouble();

		diagonal = Math.sqrt(Math.pow(baseRetangulo, 2) + Math.pow(alturaRetangulo, 2));

		System.out.println("AREA = " + baseRetangulo * alturaRetangulo);
		System.out.println("PERIMETRO = " + (2 * (baseRetangulo + alturaRetangulo)));
		System.out.println("DIAGONAL = " + diagonal);

		s.close();
	}
}