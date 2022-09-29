import java.util.Scanner;

public class Ex1191 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a, b, out;
        String exp;

        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            exp = s.next();
            a = Character.getNumericValue(exp.charAt(0));
            b = Character.getNumericValue(exp.charAt(2));

            if (a == b) out = a * b;
            else if (Character.isUpperCase(exp.charAt(1))) out = b - a;
            else out = a + b;

            System.out.println(out);
        }
    }
}