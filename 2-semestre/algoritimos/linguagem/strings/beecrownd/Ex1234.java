import java.util.Scanner;

public class Ex1234 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (s.hasNextLine()) {
            char[] txt = s.nextLine().toLowerCase().toCharArray();
            boolean upper = true;

            for (int c : txt) {
                if (c != ' ') {
                    if (upper) c -= 32;
                    upper = !upper;
                }

                System.out.print((char) c);
            }

            System.out.println();
        }
    }
}