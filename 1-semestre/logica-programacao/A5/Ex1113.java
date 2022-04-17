import java.util.Scanner;

public class Ex1113 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int primeiro, segundo;

		while (true) {
			primeiro = s.nextInt();
			segundo = s.nextInt();

			if (primeiro != segundo) {
				System.out.println((primeiro > segundo) ? "Decrescente" : "Crescente");
			} else {
				break;
			}
		}

		s.close();
	}
}
