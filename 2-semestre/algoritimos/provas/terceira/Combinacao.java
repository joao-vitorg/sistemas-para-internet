import java.util.Scanner;

public class Combinacao {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int k = s.nextInt();

        System.out.printf("Total de grupos = %d\n", comb(n, k));
    }

    public static int comb(int n, int k) {
        if (k == 1) return n;
        if (k == n) return 1;
        return comb(n-1, k-1) + comb(n-1, k);
    }
}
