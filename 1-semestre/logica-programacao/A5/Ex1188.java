import java.util.Scanner;

public class Ex1188 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double soma = 0;
        double[][] matriz = new double[12][12];

        char t = s.next().charAt(0);

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                matriz[i][j] = s.nextDouble();
            }
        }

        for (int i = 7; i <= 11; i++) {
            for (int j = 12 - i; j <= i - 1; j++) {
                soma += matriz[i][j];
            }
        }

        System.out.printf("%.1f\n", (t == 'S' ? soma : (soma / 30.0)));
    }
}
