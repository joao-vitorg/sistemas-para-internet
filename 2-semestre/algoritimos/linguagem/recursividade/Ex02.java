import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int n = s.nextInt();
        System.out.printf("O MDC de (%d, %d) = %d\n", x, n, mdc(x, n));
    }

    public static int mdc(int x, int y) {
        if ((y <= x) && (x % y == 0)) return y;
        if (x < y) return mdc(y, x);
        return mdc(y, x % y);
    }
}
