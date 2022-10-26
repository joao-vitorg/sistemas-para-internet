import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumeroNegativo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<Integer> lista = new ArrayList<>();

        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            lista.add(s.nextInt());
        }

        Collections.reverse(lista);

        lista.stream().filter(i -> i < 0).forEach(System.out::println);
    }
}
