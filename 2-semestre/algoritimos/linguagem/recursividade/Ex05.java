import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        double[] vet = new double[n];

        for (int i = 0; i < n; i++) {
            vet[i] = s.nextDouble();
        }

        System.out.printf("soma = %.2f\n", f(vet, n - 1));
    }

    public static double f(double[] vet, int pos) {
        if (pos == 0) return vet[pos];
        return vet[pos] + f(vet, pos - 1);
    }
}
