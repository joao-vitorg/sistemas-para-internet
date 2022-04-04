import java.util.Scanner;

public class Ex1034 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean condicao;
		int a, b, c, d;

		a = s.nextInt();
		b = s.nextInt();
		c = s.nextInt();
		d = s.nextInt();

		condicao = ((b > c && d > a) && (c + d > a + b) && (c >= 0 && d >= 0) && (a % 2 == 0));

		System.out.println(condicao ? "Valores aceitos" : "Valores nao aceitos");

		s.close();
	}
}