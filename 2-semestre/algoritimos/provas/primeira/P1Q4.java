import java.util.Scanner;

public class P1Q4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int soma;

        char[] txt = s.nextLine().toCharArray();

        for (char c : txt) {
            if (c == ' ') soma = 0;
            else if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') soma = 1;
            else if (Character.isDigit(c)) soma = -2;
            else soma = 3;

            System.out.printf("%c", c + soma);
        }
    }
}
