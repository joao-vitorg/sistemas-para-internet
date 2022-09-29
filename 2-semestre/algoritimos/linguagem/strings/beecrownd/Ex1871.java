import java.util.Scanner;

class Ex1871 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n1, n2;

        while (true) {
            n1 = s.nextInt();
            n2 = s.nextInt();

            if (n1 == 0 && n2 == 0) break;

            System.out.println(Integer.toString(n1 + n2).replace("0", ""));
        }
    }
}