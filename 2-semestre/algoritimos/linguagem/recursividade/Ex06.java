import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String n = s.nextLine();
        int d = s.nextInt();
        System.out.println(f(n, d, n.length() - 1));
    }

    public static int f(String n, int d, int pos) {
        int v = n.charAt(pos) - '0';

        if ((pos == 0) && (v == d)) return 1;
        if (pos == 0) return 0;
        if (v == d) return 1 + f(n, d, pos - 1);
        return f(n, d, pos - 1);
    }
}
