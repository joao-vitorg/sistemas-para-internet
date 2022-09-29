import java.util.Scanner;

public class Ex2062 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            String txt = s.next();

            if (txt.length() == 3 && (txt.startsWith("OB") || txt.startsWith("UR")) && !txt.endsWith("I")) {
                txt = txt.substring(0, 2) + "I";
            }

            System.out.print(txt + ((i != n - 1) ? " " : "\n"));
        }
    }
}
