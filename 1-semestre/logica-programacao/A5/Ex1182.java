import java.util.Scanner;

public class Ex1182 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double soma = 0;
        double[][] matriz = new double[12][12];

        int l = s.nextInt();
        char t = s.next().charAt(0);

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                matriz[i][j] = s.nextDouble();
            }
        }

        for (int i = 0; i < 12; i++) {
            soma += matriz[i][l];
        }

        if (t == 'S') {
            System.out.printf("%.1f\n", soma);
        } else {
            System.out.printf("%.1f\n", soma / 12.0);
        }
    }
}