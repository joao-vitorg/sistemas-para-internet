import java.util.Scanner;

public class P1Q2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int soma = 0;

        char[] nome = s.next().toCharArray();

        for (char c : nome) {
            if (c == '1') soma++;
        }

        System.out.println(soma);
    }
}
