import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class NumerosPositivos {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Double> array = new ArrayList<>();

        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            array.add(s.nextDouble());
        }

        for (double d : array) {
            if (d >= 0) System.out.printf("%.2f\n", d);
        }
    }
}
