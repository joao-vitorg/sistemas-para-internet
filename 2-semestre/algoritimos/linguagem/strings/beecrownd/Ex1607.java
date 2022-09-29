import java.util.Scanner;

public class Ex1607 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] exp1, exp2;
        int count;

        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            exp1 = s.next().toCharArray();
            exp2 = s.next().toCharArray();
            count = 0;

            for (int j = 0; j < exp1.length; j++) {
                if (exp1[j] == exp2[j]) continue;

                if (exp1[j] < exp2[j]) {
                    count += exp2[j] - exp1[j];
                } else {
                    count += (122 - exp1[j]) + (exp2[j] - 96);
                }
            }

            System.out.println(count);
        }
    }
}