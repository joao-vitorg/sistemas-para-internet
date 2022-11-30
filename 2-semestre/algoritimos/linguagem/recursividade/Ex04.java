import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String t = s.nextLine();
        int r = s.nextInt();
        System.out.printf(f(r, t));
    }

    public static String f(int r, String t) {
        if (r == 0) return "";
        if (r == 1) return t;
        return t + "-" + f(r - 1, t);
    }
}
