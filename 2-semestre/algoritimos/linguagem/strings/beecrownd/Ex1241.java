import java.util.Scanner;

class Ex1241 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a, b;

        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            a = s.next();
            b = s.next();

            System.out.println(a.endsWith(b) ? "encaixa" : "nao encaixa");
        }
    }
}