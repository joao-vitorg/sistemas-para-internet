import java.util.Scanner;

class LetrasFrase {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String text = s.nextLine();

        for (int i = 0; i < text.length(); i++) {
            System.out.printf("%d - %c\n", i, text.charAt(i));
        }
    }
}
