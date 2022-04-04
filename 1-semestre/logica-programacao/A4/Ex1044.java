import java.util.Scanner;

public class Ex1044 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a, b;

		a = s.nextInt();
		b = s.nextInt();

		System.out.println((Math.max(a, b) % Math.min(a, b) == 0) ? "Sao Multiplos" : "Nao sao Multiplos");

		s.close();
	}
}
