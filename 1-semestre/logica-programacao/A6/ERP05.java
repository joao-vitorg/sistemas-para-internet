import java.util.Scanner;

public class ERP05 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		for (int i = 0, n = s.nextInt(); i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}

			System.out.println();
		}

		s.close();
	}
}
