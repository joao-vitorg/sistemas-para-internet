import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int n = s.nextInt();
        System.out.println(exp(x, n));
    }

    public static int exp(int x, int n) {
        if (n == 0) return 1;
        return x * exp(x, n - 1);
    }
}
