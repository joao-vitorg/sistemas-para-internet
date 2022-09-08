import java.util.Scanner;

class ManipularCaracteres {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        char[] texto = s.nextLine().toCharArray();

        for (char c : texto) {
            if (!Character.isDigit(c)) System.out.printf("%c", c);
            else System.out.printf("%c", ((c == 57) ? '0' : c + 1));
        }

        System.out.println();
    }
} 