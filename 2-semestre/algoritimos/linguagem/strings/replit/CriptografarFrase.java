import java.util.Scanner;

class CriptografarFrase {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        char[] texto = s.nextLine().toCharArray();

        for (char c : texto) {
            System.out.printf("%c", c == 32 ? c : c + 3);
        }

        System.out.println();
    }
}