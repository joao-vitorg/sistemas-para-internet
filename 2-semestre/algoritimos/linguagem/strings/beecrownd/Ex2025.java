import java.util.Scanner;

public class Ex2025 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int length;
        String t;

        int n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            String[] txt = s.nextLine().split(" ");

            length = txt.length;
            for (int j = 0; j < length; j++) {
                t = txt[j];

                if (t.startsWith("oulupukk", 1)) {
                    System.out.print("Joulupukki" + (t.length() == 11 ? "." : ""));
                } else {
                    System.out.print(t);
                }

                System.out.print(j == length - 1 ? "\n" : " ");
            }
        }
    }
}
