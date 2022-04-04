import java.util.Scanner;

public class Ex1041 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String resposta;
		Double x, y;

		x = s.nextDouble();
		y = s.nextDouble();

		if (x == 0 || y == 0) {
			resposta = ((x == 0) ? ((y == 0) ? "Origem" : "Eixo Y") : "Eixo X");
		} else if (x > 0) {
			resposta = (y > 0) ? "Q1" : "Q4";
		} else if (x < 0) {
			resposta = (y > 0) ? "Q2" : "Q3";
		} else {
			resposta = (y == 0) ? "Eixo X" : "Eixo Y";
		}

		System.out.println(resposta);

		s.close();
	}
}