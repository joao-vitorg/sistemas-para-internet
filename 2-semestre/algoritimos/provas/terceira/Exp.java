import java.util.Scanner;

public class Exp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(exp(s.nextInt(), s.nextInt()));
    }

    public static int exp(int x, int n){
        if (n == 0) return 1;
        else return x * exp(x, n - 1);
    }
}
