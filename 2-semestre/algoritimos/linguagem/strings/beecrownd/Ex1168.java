import java.util.Scanner;
import java.util.stream.IntStream;

public class Ex1168 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] leds = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

        int n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            IntStream num = s.nextLine().chars();

            int soma = num.reduce(0, (a, b) -> a + leds[b - 48]);

            System.out.printf("%d leds\n", soma);
        }
    }
}
