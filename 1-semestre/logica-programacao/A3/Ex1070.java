import java.util.Scanner;

public class Ex1070 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		for (int i = 0, x = (s.nextInt() | 1); i < 6; i++, x += 2) {
			System.out.println(x);
		}

		s.close();
	}
}
