import java.util.Scanner;

public class ERP03 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a, b;

		a = s.nextInt();
		b = s.nextInt();

		for (int i = a + (a & 1); i <= b; i += 2) {
			System.out.println(i);
		}

		s.close();
	}
}
