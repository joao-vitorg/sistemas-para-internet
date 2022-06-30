import java.util.Scanner;

public class Ex1115 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String resposta;
		int x, y;

		while (true) {
			x = s.nextInt();
			y = s.nextInt();

			if (x > 0) {
				resposta = ((y > 0) ? "primeiro" : "quarto");
			} else if (x < 0) {
				resposta = ((y > 0) ? "segundo" : "terceiro");
			} else {
				break;
			}

			System.out.println(resposta);
		}

		s.close();
	}
}