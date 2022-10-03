import java.util.Scanner;

public class Ex1045 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		float a, b, c, min, max, mid;

		a = s.nextFloat();
		b = s.nextFloat();
		c = s.nextFloat();

		max = Math.max(a, Math.max(b, c));
		min = Math.min(a, Math.min(b, c));
		mid = (a + b + c) - max - min;

		if (max >= (mid + min)) {
			System.out.println("NAO FORMA TRIANGULO");
		} else {
			float powA, powBC;
			String resposta;

			powA = max * max;
			powBC = mid * mid + min * min;

			resposta = ((powA == powBC) ? "RETANGULO" : ((powA > powBC) ? "OBTUSANGULO" : "ACUTANGULO"));
			System.out.println("TRIANGULO " + resposta);

			if (max == mid && mid == min) {
				System.out.println("TRIANGULO EQUILATERO");
			} else if (max == mid || max == min || mid == min) {
				System.out.println("TRIANGULO ISOSCELES");
			}
		}

		s.close();
	}
}