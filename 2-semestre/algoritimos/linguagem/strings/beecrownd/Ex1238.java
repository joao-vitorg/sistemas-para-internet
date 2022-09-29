import java.util.Scanner;

public class Ex1238 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int min;

        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            String c1 = s.next();
            String c2 = s.next();

            min = Math.min(c1.length(), c2.length());
            for (int j = 0; j < min; j++) {
                System.out.printf("%c%c", c1.charAt(j), c2.charAt(j));
            }

            System.out.println((c1.length() > min ? c1 : c2).substring(min));
        }
    }
}
