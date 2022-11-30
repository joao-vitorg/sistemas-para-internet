import java.util.Scanner;

class Ex03 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(soma(s.nextInt()));
    }

    public static int soma(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + soma(n - 1);
        }
    }
}
