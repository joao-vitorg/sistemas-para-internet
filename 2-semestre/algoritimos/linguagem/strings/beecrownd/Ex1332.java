import java.util.Scanner;

public class Ex1332 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            char[] txt = s.next().toCharArray();

            if (txt.length == 5) {
                System.out.println(3);
            } else if (comp(txt[0], 't') + comp(txt[1], 'w') + comp(txt[2], 'o') >= 2) {
                System.out.println(2);
            } else {
                System.out.println(1);
            }
        }
    }

    private static int comp(char c, char v) {
        return c == v ? 1 : 0;
    }
}
