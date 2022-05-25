import java.util.Scanner;

public class Ex1170 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		for (int i = s.nextInt(), sum = 0; i != 0; i--, sum = 0) {
			for (double j = s.nextInt(); j > 1; j /= 2) {
				sum++;
			}

			System.out.println(sum + " dias");
		}

		s.close();
	}
}
