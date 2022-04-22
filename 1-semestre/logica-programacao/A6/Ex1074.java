import java.util.Scanner;

public class Ex1074 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		for (int x, n = s.nextInt(); n > 0; n--) {
			x = s.nextInt();

			if (x == 0) {
				System.out.println("NULL");
			} else {
				System.out.print((x % 2 == 0) ? "EVEN " : "ODD ");
				System.out.println((x > 0) ? "POSITIVE" : "NEGATIVE");
			}
		}

		s.close();
	}
}
