import java.util.Scanner;

public class Ex1253 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t;

        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            char[] txt = s.next().toCharArray();
            t = s.nextInt();

            for (char c : txt) {
                if ((c - 'A') - t >= 0) System.out.print((char) (c - t));
                else System.out.print((char) (91 - t + (c - 'A')));
            }

            System.out.println();
        }
    }
}
