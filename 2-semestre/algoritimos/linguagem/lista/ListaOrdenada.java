import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListaOrdenada {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<Integer> lista = new ArrayList<>();

        int n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            lista.add(s.nextInt());
        }

        System.out.print("Original : ");
        System.out.println(lista.stream().map(String::valueOf).collect(Collectors.joining("-")));

        Collections.sort(lista);

        System.out.print("Ordenado : ");
        System.out.println(lista.stream().map(String::valueOf).collect(Collectors.joining("-")));
    }
}
