import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double soma = 0, matriz[][] = new double[12][12];

        char t = s.next().charAt(0);

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                matriz[i][j] = s.nextDouble();
            }
        }

        for (int i = 1; i <= 5; i++) {
            for (int j = 11; j >= 12 - i; j--) {
                soma += matriz[i][j];
            }
        }

        for (int i = 6; i <= 10; i++) {
            for (int j = 11; j >= i + 1; j--) {
                soma += matriz[i][j];
            }
        }

        System.out.printf("%.1f\n", (t == 'S' ? soma : (soma / 30.0)));
    }
}
