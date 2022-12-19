import java.util.Scanner;

public class Ackermann {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int m = s.nextInt();
        int n = s.nextInt();

        System.out.println(a(m, n));
    }

    public static int a(int m, int n) {
        if (m == 0) return n + 1;
        if (m > 0 && n == 0) return a(m - 1, 1);
        return a(m-1, a(m, n-1));
    }
}
