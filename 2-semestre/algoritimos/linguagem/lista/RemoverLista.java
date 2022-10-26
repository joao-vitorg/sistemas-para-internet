import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoverLista {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<String> lista = new ArrayList<>();

        int n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            lista.add(s.nextLine());
        }

        lista.remove(s.nextInt() - 1);

        lista.forEach(System.out::println);
    }
}
