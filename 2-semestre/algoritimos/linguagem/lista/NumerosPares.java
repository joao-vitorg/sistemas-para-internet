import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumerosPares {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<Integer> lista = new ArrayList<>();

        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            lista.add(s.nextInt());
        }

        List<Integer> numerosPares = lista.stream().filter(i -> (i & 1) == 0).toList();

        numerosPares.forEach(System.out::println);

        System.out.println(numerosPares.size());
    }
}
