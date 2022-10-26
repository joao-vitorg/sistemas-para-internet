import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListaInversa {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<String> lista = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            lista.add(s.nextLine());
        }

        Collections.reverse(lista);

        lista.forEach(System.out::println);
    }
}
