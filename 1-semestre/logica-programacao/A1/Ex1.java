import java.util.Scanner;

public class Ex1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int mediaFrente, mediaLados, precoMetro, area;

		System.out.println("Medida de frente: ");
		mediaFrente = s.nextInt();

		System.out.println("Medida de lados: ");
		mediaLados = s.nextInt();

		System.out.println("Preco do metro quadrado:");
		precoMetro = s.nextInt();

		area = mediaFrente * mediaLados;

		System.out.println("Area: " + area);
		System.out.println("Preco: " + area * precoMetro);

		s.close();
	}
}