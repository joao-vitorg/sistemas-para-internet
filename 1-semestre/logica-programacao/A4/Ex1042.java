import java.util.Scanner;

public class Ex1042 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a, b, c, min, max, mid;

		a = s.nextInt();
		b = s.nextInt();
		c = s.nextInt();

		max = Math.max(a, Math.max(b, c));
		min = Math.min(a, Math.min(b, c));
		mid = (a + b + c) - max - min;

		System.out.println(min);
		System.out.println(mid);
		System.out.println(max);

		System.out.println();

		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		s.close();
	}
}
